package com.example.ecommerce.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtTokenUtil;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}

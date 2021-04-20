package com.example.ecommerce.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    UserServices userServices;

    @GetMapping("/users")
    public ResponseEntity<Map> getUsers(){
        return new ResponseEntity<Map>(userServices.getUserDetails(), HttpStatus.OK);
    }
}

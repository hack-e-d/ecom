package com.example.ecommerce.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/purchases")
    public ResponseEntity<Map> getPurchases(){
        Map<String,Object> payload = new HashMap<String, Object>();
        payload.put("Status","Success");
        payload.put("Status Code","S");
        payload.put("Result",purchaseService.getPurchases());
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }
}

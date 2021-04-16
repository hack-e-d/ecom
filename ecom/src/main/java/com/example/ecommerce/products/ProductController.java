package com.example.ecommerce.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    //ProductServiceImpl productServiceImpl = new ProductServiceImpl();
    ProductService productService;


//    @GetMapping("/products")
//    public String getProducts(@RequestParam("userId") String userId,
//                              @RequestParam(value = "clientId",required = false,defaultValue = "10")
//                                      String clientId){
//        return "product "+userId+clientId;
//    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<Map> getProducts(@PathVariable("productId") String productId){
        Map<String,Object> pdt = new HashMap<String,Object>();
        pdt.put("status", "Success");
        pdt.put("statusCode", "S");
        pdt.put("result",productService.getProducts(productId));
        return new ResponseEntity<Map>(pdt, HttpStatus.OK);
    }
    @PostMapping("/addproducts/{productId}")
    public ResponseEntity<Map> addProductDetails(@RequestBody HashMap<String,Object> payload) {
        Map<String,Object> response = new HashMap<String,Object>();
        response.put("status", "Success");
        response.put("statusCode", "S");
        response.put("result",productService.addProductDetails(payload));
        return new ResponseEntity<Map>(response, HttpStatus.OK);

    }
    @PostMapping("/updateproducts/{productId}")
    public ResponseEntity<Map> updateProductDetails(@RequestBody HashMap<String,Object> payload) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("status", "Success");
        response.put("statusCode", "S");
        response.put("result", productService.updateProductDetails(payload));
        return new ResponseEntity<Map>(response, HttpStatus.OK);
    }
    @PostMapping("/deleteproducts/{productId}")
    public ResponseEntity<Map> deleteProductDetails(@PathVariable("productId") String productId) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("status", "Success");
        response.put("statusCode", "S");
        response.put("result", productService.deleteProductDetails(productId));
        return new ResponseEntity<Map>(response, HttpStatus.OK);
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<Map> getUserDetails(@RequestBody HashMap<String,Object> payload) {
        Map<String,Object> response = new HashMap<String,Object>();
        response.put("status", "Success");
        response.put("statusCode", "S");
        response.put("result",productService.getUserDetails(payload));
        return new ResponseEntity<Map>(response, HttpStatus.OK);
    }
    @PutMapping("/products")
    public String getProduct3(String a){
        return "product3";
    }
    @DeleteMapping("/products")
    public String getProduct4(String a){
        return "product4";
    }
}

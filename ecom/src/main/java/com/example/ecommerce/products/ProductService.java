package com.example.ecommerce.products;

//import org.springframework.context.annotation.ComponentScan;


import java.util.HashMap;
import java.util.Map;

public interface ProductService {
    Object getProducts(String value);
    Map<String,Object> getUserDetails(HashMap<String,Object> payload);

    String addProductDetails(HashMap<String, Object> payload);
    String updateProductDetails(HashMap<String, Object> payload);
    String deleteProductDetails(String productId);
}

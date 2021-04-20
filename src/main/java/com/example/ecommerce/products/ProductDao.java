package com.example.ecommerce.products;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface ProductDao {

    List<Object> getProducts(String value);

    String addProductDetails(HashMap<String, Object> payload);
    String updateProductDetails(HashMap<String, Object> payload);
    String deleteProductDetails(String productId);
}

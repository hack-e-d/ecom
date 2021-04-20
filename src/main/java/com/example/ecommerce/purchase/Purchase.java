package com.example.ecommerce.purchase;

import lombok.Data;

public @Data class Purchase {
    private String purchaseId;
    private String productId;
    private String productCount;
}

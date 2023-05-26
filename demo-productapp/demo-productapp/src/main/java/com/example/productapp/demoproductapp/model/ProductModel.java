package com.example.productapp.demoproductapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
    private String productName;
    private String productPrice;
    private String productQuantity;
    private String productDetails;
}

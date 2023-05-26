package com.example.productapp.demoproductapp.config;

import com.example.productapp.demoproductapp.model.ProductModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product-app")
public interface FeignProductConfig {
    @GetMapping("/get-products")
    ResponseEntity<List<ProductModel>> getAllProducts();
}

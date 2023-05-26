package com.example.productapp.demoproductapp.service;

import com.example.productapp.demoproductapp.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductModel> getAllProducts();
}

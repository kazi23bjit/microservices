package com.example.productapp.demoproductapp.service.impl;

import com.example.productapp.demoproductapp.entity.Product;
import com.example.productapp.demoproductapp.model.ProductModel;
import com.example.productapp.demoproductapp.repository.ProductRepository;
import com.example.productapp.demoproductapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<ProductModel> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductModel> requiredProducts = new ArrayList<>();
        for(Product product:products){
            ProductModel requiredProduct = ProductModel.builder()
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productQuantity(product.getProductQuantity())
                    .productDetails(product.getProductDetails()).build();
            requiredProducts.add(requiredProduct);
        }
        return requiredProducts;
    }
}

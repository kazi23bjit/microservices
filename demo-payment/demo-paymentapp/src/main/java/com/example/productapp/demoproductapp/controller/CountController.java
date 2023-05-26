package com.example.productapp.demoproductapp.controller;

import com.example.productapp.demoproductapp.DemoPaymentappApplication;
import com.example.productapp.demoproductapp.config.FeignProductConfig;
import com.example.productapp.demoproductapp.model.ProductModel;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountController {

    @Autowired
    FeignProductConfig feignProductConfig;
    @GetMapping("/getCount")
    public  Integer getCount(){
        return DemoPaymentappApplication.COUNTER++;
    }

    @GetMapping("/get-product-from-product")
    public ResponseEntity<List<ProductModel>> showAllproducts(){
        return feignProductConfig.getAllProducts();
    }

}

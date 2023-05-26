package com.example.productapp.demoproductapp.controller;

import com.example.productapp.demoproductapp.DemoPaymentappApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    @GetMapping("/getCount")
    public  Integer getCount(){
        return DemoPaymentappApplication.COUNTER++;
    }

}

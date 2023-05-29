package com.example.paymentapp.demopaymentapp.config;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order-app")
public interface FeignOrderConfig {
}

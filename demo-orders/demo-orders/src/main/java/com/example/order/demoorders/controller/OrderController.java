package com.example.order.demoorders.controller;

import com.example.order.demoorders.model.OrderModel;
import com.example.order.demoorders.model.OrderResponse;
import com.example.order.demoorders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private  final OrderService orderService;
    @PostMapping("/order-creation")
    public OrderResponse createOrder(@RequestBody OrderModel orderModel){
        return orderService.createOrder(orderModel);
        //return "Order added";
    }
}

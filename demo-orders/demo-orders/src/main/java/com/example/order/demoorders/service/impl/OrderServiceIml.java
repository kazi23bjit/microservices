package com.example.order.demoorders.service.impl;

import com.example.order.demoorders.config.FeignProductConfig;
import com.example.order.demoorders.entity.Order;
import com.example.order.demoorders.model.CartItems;
import com.example.order.demoorders.model.OrderModel;
import com.example.order.demoorders.model.OrderResponse;
import com.example.order.demoorders.repository.OrderRepository;
import com.example.order.demoorders.service.KafkaProducerService;
import com.example.order.demoorders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceIml implements OrderService {
    private final OrderRepository orderRepository;
    private final FeignProductConfig feignProductConfig;
    private final KafkaProducerService orderProducer;
    @Override
    public OrderResponse createOrder(OrderModel orderModel) {
        List<CartItems> cartItems = orderModel.getCartItems();
//
//        List<CartItems> responseCartItems = new ArrayList<>();
//        for(CartItems cartItem:cartItems){
//            Integer pQuantity = Integer.parseInt(feignProductConfig.getProductStock(cartItem.getProductName()));
//            Integer oQuantity = Integer.parseInt(cartItem.getProductQuantity());
//            if(oQuantity<pQuantity){
//                responseCartItems.add(cartItem);
//            }
//            else{
//                cartItem.setProductQuantity("not in stock");
//                responseCartItems.add(cartItem);
//            }
//        }
        Order order = Order.builder()
                .orderStatus(orderModel.getOrderStatus())
                .address(orderModel.getAddress())
                .build();
        orderRepository.save(order);
        OrderResponse orderResponse = OrderResponse.builder()
                .orderStatus(order.getOrderStatus())
                .address(order.getAddress())
                .cartItems(cartItems).build();
        orderProducer.sendMessage(orderResponse);
        return orderResponse;
//        orderRepository.save(order);
//        OrderModel orderModel1 = OrderModel.builder()
//                .orderStatus(order.getOrderStatus())
//                .address(order.getAddress())
//                .cartItems(cartItems).build();
        //return "order is " + order.getOrderStatus();
//        if(oQuantity<pQuantity){
//            Order order = Order.builder()
//                    .orderStatus(orderModel.getOrderStatus())
//                    .productQuantity(orderModel.getQuantity())
//                    .build();
//            orderRepository.save(order);
//            return "Order is created";
//        }
//        else{
//            return "Cannt be ordered";
//        }
        //return "Order added";
    }

}

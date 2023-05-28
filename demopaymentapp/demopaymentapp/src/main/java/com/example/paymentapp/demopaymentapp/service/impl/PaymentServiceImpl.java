package com.example.paymentapp.demopaymentapp.service.impl;

import com.example.paymentapp.demopaymentapp.config.FeignProductConfig;
import com.example.paymentapp.demopaymentapp.model.CartItems;
import com.example.paymentapp.demopaymentapp.model.InvoiceModel;
import com.example.paymentapp.demopaymentapp.model.OrderResponse;
import com.example.paymentapp.demopaymentapp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final FeignProductConfig feignProductConfig;
    //private InvoiceModel invoiceModel;
    private List<CartItems>globalCartItems = new ArrayList<>();
    private String globalAddress;
    private String globalOrderStatus;
    private String globalFinalPrice;
    @Override
    public void validateOrder(OrderResponse orderResponse) {
        List<CartItems> cartItems = orderResponse.getCartItems();
        List<CartItems> responseCartItems = new ArrayList<>();

        Integer totalPrice = 0;
        for(CartItems cartItem:cartItems){
            Integer pQuantity = Integer.parseInt(feignProductConfig.getProductStock(cartItem.getProductName()));
            Integer productPrice = Integer.parseInt(feignProductConfig.getProductPrice(cartItem.getProductName()));

            Integer productPricePerQuantity = pQuantity*productPrice;
            Integer oQuantity = Integer.parseInt(cartItem.getProductQuantity());
            if(oQuantity<pQuantity){
                responseCartItems.add(cartItem);
                totalPrice += productPricePerQuantity;
                globalCartItems.add(cartItem);
                feignProductConfig.updateProductStock(cartItem.getProductName(), cartItem.getProductQuantity());
            }
            else{
                cartItem.setProductQuantity("Not in stock");
                responseCartItems.add(cartItem);
            }
        }
        globalAddress = orderResponse.getAddress();
        globalOrderStatus = "SUCCESSFUL";

        String finalPrice = String.valueOf(totalPrice);
        globalFinalPrice = finalPrice;

//        InvoiceModel invoiceModel = InvoiceModel.builder()
//                .orderStatus("Successful")
//                .address(orderResponse.getAddress())
//                .cartItems(responseCartItems)
//                .totalPrice(finalPrice).build();
//
//        return invoiceModel;
    }


    @Override
    public InvoiceModel getInvoice(){
        Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
        InvoiceModel invoiceModel = InvoiceModel.builder()
                .address(globalAddress)
                .orderStatus(globalOrderStatus)
                .totalPrice(globalFinalPrice)
                .cartItems(globalCartItems).build();
        logger.info("invoice model:"+invoiceModel);
        return invoiceModel;
    }
}

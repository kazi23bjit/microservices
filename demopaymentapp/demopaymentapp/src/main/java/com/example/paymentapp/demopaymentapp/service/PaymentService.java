package com.example.paymentapp.demopaymentapp.service;

import com.example.paymentapp.demopaymentapp.model.InvoiceModel;
import com.example.paymentapp.demopaymentapp.model.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    void validateOrder(OrderResponse orderResponse);
    InvoiceModel getInvoice();
//    void setInvoiceModel(InvoiceModel invoiceModel);
}

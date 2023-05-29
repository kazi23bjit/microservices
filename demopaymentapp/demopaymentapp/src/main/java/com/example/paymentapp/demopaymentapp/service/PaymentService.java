package com.example.paymentapp.demopaymentapp.service;

import com.example.paymentapp.demopaymentapp.model.InvoiceModel;
import com.example.paymentapp.demopaymentapp.model.OrderResponse;
import com.example.paymentapp.demopaymentapp.model.PaymentModel;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    void validateOrder(OrderResponse orderResponse);
    InvoiceModel getInvoice(Long id);
    String finalResult(PaymentModel paymentModel);
//    void setInvoiceModel(InvoiceModel invoiceModel);
}

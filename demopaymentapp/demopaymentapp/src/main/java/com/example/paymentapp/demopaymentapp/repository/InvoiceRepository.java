package com.example.paymentapp.demopaymentapp.repository;

import com.example.paymentapp.demopaymentapp.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findByUserId(Long userId);
}

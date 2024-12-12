package com.fds.service;

import com.fds.entity.Payment;
import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
    void deletePayment(Long id);
}

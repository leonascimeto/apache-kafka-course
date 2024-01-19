package tech.leondev.paymentservice.service;

import tech.leondev.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}

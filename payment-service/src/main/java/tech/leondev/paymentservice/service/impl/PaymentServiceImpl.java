package tech.leondev.paymentservice.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.paymentservice.model.Payment;
import tech.leondev.paymentservice.service.PaymentService;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL ::: Recebi o pagamento: {}", payment);
    }
}

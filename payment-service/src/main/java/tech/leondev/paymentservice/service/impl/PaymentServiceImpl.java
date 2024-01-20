package tech.leondev.paymentservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tech.leondev.paymentservice.model.Payment;
import tech.leondev.paymentservice.service.PaymentService;

import java.io.Serializable;

@Log4j2
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT_SERVICE_IMPL ::: Recebi o pagamento: {}", payment);
        Thread.sleep(1000);

        log.info("PAYMENT_SERVICE_IMPL ::: enviando pagamento ...");
        kafkaTemplate.send("payment-topic", payment);
    }
}

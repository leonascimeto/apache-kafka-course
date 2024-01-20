package tech.leondev.jsonconsumer.listener;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import tech.leondev.jsonconsumer.model.Payment;

import static java.lang.Thread.*;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        log.debug("Data: {}", payment.toString());
        log.info("Validando fraude ...");
        sleep(5000);

        log.info("Compra aprovada!");
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        sleep(10000);

        log.info("Gerando pdf de {} ...", payment.getId());
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment) {
        sleep(15000);
        log.info("Enviando Email de comfirmação ...");
    }
}

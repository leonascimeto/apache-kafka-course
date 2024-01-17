package tech.leondev.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    @KafkaListener(topics = "str-topic", groupId = "group-1", containerFactory = "strContainerFactory")
    public void listener(String message) {
        log.info("Message received: {}", message);
    }
}

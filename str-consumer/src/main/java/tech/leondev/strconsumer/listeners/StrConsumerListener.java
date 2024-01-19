package tech.leondev.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import tech.leondev.strconsumer.custom.StrConsumerCustomListener;

@Component
@Log4j2
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        log.info("CREATE ::: Message received: {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Message received: {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-2")
    public void history(String message) {
        log.info("HISTORY ::: Message received: {}", message);
    }
}

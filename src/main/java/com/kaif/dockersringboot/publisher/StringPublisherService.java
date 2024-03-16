package com.kaif.dockersringboot.publisher;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class StringPublisherService {
    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendStringMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send("stringtopic", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("published string message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to published message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });

    }
    
}

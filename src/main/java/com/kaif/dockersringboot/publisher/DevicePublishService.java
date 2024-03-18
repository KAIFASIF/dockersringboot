package com.kaif.dockersringboot.publisher;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.kaif.dockersringboot.entities.Device;

@Service
public class DevicePublishService {

     @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendCustomerMessageToTopic(Device payload) {
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("customer-topic", payload);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("publisher customer message=[" + payload.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                    payload.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }

    }
    
}
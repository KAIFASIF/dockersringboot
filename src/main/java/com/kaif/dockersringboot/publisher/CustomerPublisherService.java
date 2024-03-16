package com.kaif.dockersringboot.publisher;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.kaif.dockersringboot.entities.Customer;

@Service
public class CustomerPublisherService {

     @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendCustomerMessageToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("customer-topic", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("publisher customer message=[" + customer.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            customer.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }

    }
    
}

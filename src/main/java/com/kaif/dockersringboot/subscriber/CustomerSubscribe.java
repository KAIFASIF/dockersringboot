
package com.kaif.dockersringboot.subscriber;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kaif.dockersringboot.entities.Customer;


@Service
public class CustomerSubscribe {

    Logger log = LoggerFactory.getLogger(CustomerSubscribe.class);

    @KafkaListener(topics = "customer-topic", groupId = "customergroup")
    public void listen(Customer customer) {
        log.info("Subscribed customer json: {}", customer);
    }


}

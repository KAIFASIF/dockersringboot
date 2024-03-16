
package com.kaif.dockersringboot.subscriber;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class StringSubscribe {

    Logger log = LoggerFactory.getLogger(StringSubscribe.class);

    @KafkaListener(topics = "stringtopic", groupId = "stringgroup")
    public void listen(String message) {
        log.info("Subscribed string message: {}", message);
        // log.info("Subscribed string messagedd: {}", message);
    }


}

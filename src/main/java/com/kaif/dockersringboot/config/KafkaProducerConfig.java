package com.kaif.dockersringboot.config;

import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic() {
        // return new NewTopic("string-topic", 3, (short) 1);
        return new NewTopic("device-topic", 3, (short) 1);
        // return new NewTopic("wikimedia-topic", 3, (short) 1);

    }

}
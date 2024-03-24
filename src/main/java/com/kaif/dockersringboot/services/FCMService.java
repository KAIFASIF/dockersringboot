package com.kaif.dockersringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.kaif.dockersringboot.entities.Device;
import org.springframework.stereotype.Service;

@Service
public class FCMService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public void sendPushNotification(Device payload) throws JsonProcessingException, FirebaseMessagingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValueAsString(objectMapper);
        String jsonDataString = objectMapper.writeValueAsString(payload);

        Message message = Message.builder()
                .setToken(redisTemplate.opsForValue().get("fcmToken"))
                .putData("jsonData", jsonDataString)
                .build();

        firebaseMessaging.send(message);
    }

}

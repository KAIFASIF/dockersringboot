package com.kaif.dockersringboot.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.publisher.DevicePublisher;
import com.kaif.dockersringboot.services.FCMService;
import org.springframework.http.ResponseEntity;

@RestController
public class DeviceContoller {

    @Autowired
    private DevicePublisher devicePublisher;

     @Autowired
    private FirebaseMessaging firebaseMessaging;

    String fcmtoken ="dsatoken";

    @PostMapping("/fcm-token")
    public String verifyTokenGetMethod(@RequestBody Map<String, String> token) {
        try {
            // String fcmToken = token.get("fcmToken");
            // redisTemplate.opsForValue().set("fcmToken", fcmToken);
            fcmtoken = token.get("fcmToken");
            return "Fcm token saved successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fcm token not saved";
        }
    }


    @PostMapping("/send")
    public ResponseEntity<?> saveDevice(@RequestBody Device payload) {
        try {
            if (payload.getCurrent() > 12) {
                sendPushNotification(payload);
            }
            devicePublisher.sendDeviceMessageToTopic(payload);
            return ResponseEntity.ok("json data published successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Error in publishing json data");
        }
    }

    
    public void sendPushNotification(Device payload) throws JsonProcessingException, FirebaseMessagingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValueAsString(objectMapper);
        String jsonDataString = objectMapper.writeValueAsString(payload);

        Message message = Message.builder()
                .setToken(fcmtoken)
                // .setToken(redisTemplate.opsForValue().get("fcmToken"))
                .putData("jsonData", jsonDataString)
                .build();

        firebaseMessaging.send(message);
    }

}

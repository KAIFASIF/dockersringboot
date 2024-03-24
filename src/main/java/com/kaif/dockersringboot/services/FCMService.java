package com.kaif.dockersringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
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
    private FirebaseMessaging firebaseMessaging;

    public void sendPushNotification(Device payload) throws JsonProcessingException, FirebaseMessagingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValueAsString(objectMapper);
        String jsonDataString = objectMapper.writeValueAsString(payload);

        Message message = Message.builder()
                .setToken(
                        "fjFrS7TjTxjsONSCo92kK3:APA91bEtQtZ6CnxtDiEDQuxcqQ_6CbLiGt7IWjLYZNYknHOO-ZHILo0-7uQxZhfJIXRuLTlwb_6WIbRua_jTWH4RxfiGOkOWHP9vVa562nifY3NA7tXupeUMCcnEEbMOSWuyVMm35f53")
                .putData("jsonData", jsonDataString)
                .build();

        firebaseMessaging.send(message);
    }

}

package com.kaif.dockersringboot.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessaging;
import com.kaif.dockersringboot.entities.Device;

import com.kaif.dockersringboot.services.FCMService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.repos.DeviceRepo;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DeviceController {

    @Autowired
    private FCMService fcmService;
    private Logger logger = LoggerFactory.getLogger(FCMService.class);

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    // @PostMapping("/send")
    // public ResponseEntity<?> sendPushNotification(Device payload) {
    //     try {

    //         var notification = Notification.builder().setTitle("Title").setBody("Body").build();
    //         var message = Message.builder().setToken(
    //                 "fjFrS7TjTxjsONSCo92kK3:APA91bEtQtZ6CnxtDiEDQuxcqQ_6CbLiGt7IWjLYZNYknHOO-ZHILo0-7uQxZhfJIXRuLTlwb_6WIbRua_jTWH4RxfiGOkOWHP9vVa562nifY3NA7tXupeUMCcnEEbMOSWuyVMm35f53")
    //                 .setNotification(notification).build();
    //         firebaseMessaging.send(message);

    //         return ResponseEntity.ok("Device json  published successfully ..");
    //     } catch (Exception e) {
    //         System.out.println("************************************************************");
    //         System.out.println("************************************************************");
    //         logger.error(e.getMessage());
    //         System.out.println("************************************************************");
    //         return ResponseEntity.ok("Error");
    //     }
    // }

    @PostMapping("/send")
    public ResponseEntity<?> sendFCMMessage(@RequestBody Map<String, Object> jsonData) {
        // try {
        //     Map<String, String> stringData = new HashMap<>();
        //     for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
        //         stringData.put(entry.getKey(), String.valueOf(entry.getValue()));
        //     }
    

        //     Message message = Message.builder()
        //             .setToken("fjFrS7TjTxjsONSCo92kK3:APA91bEtQtZ6CnxtDiEDQuxcqQ_6CbLiGt7IWjLYZNYknHOO-ZHILo0-7uQxZhfJIXRuLTlwb_6WIbRua_jTWH4RxfiGOkOWHP9vVa562nifY3NA7tXupeUMCcnEEbMOSWuyVMm35f53")
        //             .putAllData(stringData)
        //             .build();
    

        //     firebaseMessaging.send(message);
        //     return ResponseEntity.ok("FCM message sent successfully.");
        // } catch (Exception e) {
        //     return ResponseEntity.ok("Error sending FCM message: " + e.getMessage());
        // }

        try {
            // Convert the jsonData map to a JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonDataString = objectMapper.writeValueAsString(jsonData);
        
            // Build the FCM message
            Message message = Message.builder()
                    .setToken("fjFrS7TjTxjsONSCo92kK3:APA91bEtQtZ6CnxtDiEDQuxcqQ_6CbLiGt7IWjLYZNYknHOO-ZHILo0-7uQxZhfJIXRuLTlwb_6WIbRua_jTWH4RxfiGOkOWHP9vVa562nifY3NA7tXupeUMCcnEEbMOSWuyVMm35f53")
                    .putData("jsonData", jsonDataString)
                    .build();
        
            firebaseMessaging.send(message);
            return ResponseEntity.ok("FCM message sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.ok("Error sending FCM message: " + e.getMessage());
        }
    }

    // public ResponseEntity<?> saveDevice(@RequestBody Device payload) {
    // try {

    // return ResponseEntity.ok("Device json published successfully ..");
    // } catch (Exception ex) {
    // ex.printStackTrace();
    // return ResponseEntity.internalServerError()
    // .build();
    // }
    // }

}
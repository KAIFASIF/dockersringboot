package com.kaif.dockersringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.publisher.DevicePublisher;
import com.kaif.dockersringboot.services.FCMService;
import org.springframework.http.ResponseEntity;

@RestController
public class DeviceContoller {

    @Autowired
    private DevicePublisher devicePublisher;

    @Autowired
    private FCMService fcmService;

    @PostMapping("/send")
    public ResponseEntity<?> saveDevice(@RequestBody Device payload) {
        try {
            if (payload.getCurrent() > 12) {
                fcmService.sendPushNotification(payload);
            }
            devicePublisher.sendDeviceMessageToTopic(payload);
            return ResponseEntity.ok("json data published successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Error in publishing json data");
        }
    }

}

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
            devicePublisher.sendDeviceMessageToTopic(payload);

            if (payload.getCurrent() > 12) {
                fcmService.sendNotificationByToken(payload);
            }

            return ResponseEntity.ok("Device json  published successfully ..");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError()
                    .build();
        }
    }

}

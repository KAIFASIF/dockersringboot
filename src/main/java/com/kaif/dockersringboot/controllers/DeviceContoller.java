package com.kaif.dockersringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.publisher.DevicePublisher;
import org.springframework.http.ResponseEntity;

@RestController
public class DeviceContoller {

    @Autowired
    private DevicePublisher devicePublisher;

    @PostMapping("/send")
    public ResponseEntity<?> saveDevice(@RequestBody Device payload) {
        try {
            devicePublisher.sendDeviceMessageToTopic(payload);

            return ResponseEntity.ok("Device json  published successfully ..");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError()
                    .build();
        }
    }

}

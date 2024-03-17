package com.kaif.dockersringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.service.DeviceService;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;
    // @PostMapping("/send")
    // public String sendData(@RequestBody Map<String, Object> payload) {
    // System.out.println("**************ddddddddd*************************");
    // for (Map.Entry<String, Object> entry : payload.entrySet()) {
    // String key = entry.getKey();
    // Object value = entry.getValue();
    // System.out.println("Key: " + key + ", Value: " + value);
    // }
    // System.out.println("**************ddddddddd*************************");
    // return "post /send success";
    // }

    @PostMapping("/send")
    public ResponseEntity<?> saveDevice(@RequestBody Device data) {
        try {
            deviceService.saveDevice(data);
            return ResponseEntity.status(HttpStatus.CREATED).body("Data saved sucessfully to db");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

}
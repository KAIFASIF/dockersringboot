package com.kaif.dockersringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.repos.DeviceRepo;

@RestController
public class TestController {

    @Autowired
    private DeviceRepo deviceRepo;

    @PostMapping("/send")
    public String sendData(@RequestBody Device payload) {

        deviceRepo.save(payload);

        return "post /send success";
    }
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

}

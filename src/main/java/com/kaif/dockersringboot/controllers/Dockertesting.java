package com.kaif.dockersringboot.controllers;

import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

// import com.kaif.dockersringboot.entities.Device;
// import com.kaif.dockersringboot.repo.DeviceRepo;

@RestController
public class Dockertesting {

    // @Autowired
    // private DeviceRepo service;

    // @GetMapping("/")
    // public String testMethod() {
    // return "get sucess";
    // }

    // @PostMapping("/")
    // public String postData(@RequestBody Device data) {
    // System.out.println("************************************");
    // System.out.println(data);
    // // service.save(data);
    // System.out.println("************************************");

    // return "post success";
    // }

    @GetMapping("/")
    public String testMethod(@RequestHeader("Authorization") String token) {
        System.out.println("**************aaaaaaaaa*************************");
        System.out.println(token);
        System.out.println("**************aaaaaaaaa*************************");
        return "get / success";
    }

    @PostMapping("/")
    public String postData(@RequestHeader("Authorization") String token) {
        System.out.println("**************bbbbbbbb*************************");
        System.out.println(token);
        System.out.println("**************bbbbbbbb*************************");
        return "post / success";
    }

    @GetMapping("/send")
    public String getData(@RequestBody Map<String, Object> payload) {
        for (Map.Entry<String, Object> entry : payload.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
        System.out.println("**************cccccccc*************************");
        System.out.println("**************cccccccc*************************");
        return "get /send success";
    }

    @PostMapping("/send")
    public String sendData(@RequestBody Map<String, Object> payload) {
        for (Map.Entry<String, Object> entry : payload.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
        System.out.println("**************ddddddddd*************************");
        System.out.println("**************ddddddddd*************************");
        return "post /send success";
    }   

}

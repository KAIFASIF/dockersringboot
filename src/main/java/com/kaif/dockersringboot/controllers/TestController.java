package com.kaif.dockersringboot.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    // @GetMapping("/send")
    // public String getData(@RequestBody Map<String, Object> payload) {
    //     System.out.println("**************cccccccc*************************");
    //     for (Map.Entry<String, Object> entry : payload.entrySet()) {
    //         String key = entry.getKey();
    //         Object value = entry.getValue();
    //         System.out.println("Key: " + key + ", Value: " + value);
    //     }
    //     System.out.println("**************cccccccc*************************");
    //     return "get /send success";
    // }

    
    // @PostMapping("/send")
    // public String sendData(@RequestBody Map<String, Object> payload) {
    //     System.out.println("**************ddddddddd*************************");
    //     for (Map.Entry<String, Object> entry : payload.entrySet()) {
    //         String key = entry.getKey();
    //         Object value = entry.getValue();
    //         System.out.println("Key: " + key + ", Value: " + value);
    //     }
    //     System.out.println("**************ddddddddd*************************");
    //     return "post /send success";
    // }

}
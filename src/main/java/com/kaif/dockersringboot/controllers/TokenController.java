package com.kaif.dockersringboot.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    // @GetMapping("/send")
    // public void verifyTokenGetMethod(@RequestHeader("Authorization") String
    // token) {
    // System.out.println("************** token in header get request /home
    // *************************");
    // System.out.println(token);
    // System.out.println("**************end*************************");

    // }

    @PostMapping("/fcm-token")
    public String verifyTokenGetMethod(@RequestBody Map<String, String> token) {
        try {
            String fcmToken = token.get("fcmToken");
            redisTemplate.opsForValue().set("fcmToken", fcmToken);
            return "Fcm token saved successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fcm token not saved";
        }
    }

    // @PostMapping("/send")
    // public void verifyTokenPostMethod(@RequestHeader("Authorization") String
    // token) {
    // System.out.println("**************token in header post request
    // /home*************************");
    // System.out.println(token);
    // System.out.println("**************end*************************");
    // }

}

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
public class HeaderTokenController {

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
    public void verifyTokenGetMethod(@RequestBody Map<String, String> token) {
        System.out.println("************** token in header get request  /home *************************");
        System.out.println(token);
        // String key = token.get("fcmToken");
        // String value = token.get("value");
        // redisTemplate.opsForValue().set("fcmToken", value);
        System.out.println("**************end*************************");
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

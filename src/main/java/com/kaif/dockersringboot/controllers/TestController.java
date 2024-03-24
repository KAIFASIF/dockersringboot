package com.kaif.dockersringboot.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaif.dockersringboot.entities.Device;
import com.kaif.dockersringboot.repos.DeviceRepo;

@RestController
public class TestController {

    @Autowired
     private DeviceRepo deviceRepo;

       @Autowired
    private StringRedisTemplate redisTemplate;

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

    //  @PostMapping("/fcm-token")
    //  public void verifyTokenGetMethod(@RequestBody Map<String, String> token) {
    //      System.out.println("************** token in header get request  /home *************************");
    //      String fcmToken = token.get("fcmToken");
    //     //  System.out.println(key);
    //      // String value = token.get("value");
    //      redisTemplate.opsForValue().set("fcmToken", fcmToken);

    //      System.out.println("**************get*************************");
    //      System.out.println(redisTemplate.opsForValue().get("fcmToken"));
    //      System.out.println("**************end*************************");
    //  }

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

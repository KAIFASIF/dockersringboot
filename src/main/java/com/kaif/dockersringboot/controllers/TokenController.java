package com.kaif.dockersringboot.controllers;

// import java.util.Map
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.redis.core.StringRedisTemplate;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.google.firebase.messaging.FirebaseMessaging;
// import com.google.firebase.messaging.FirebaseMessagingException;
// import com.google.firebase.messaging.Message;
// import com.kaif.dockersringboot.entities.Device;
// import com.google.firebase.messaging.FirebaseMessaging;

@RestController
public class TokenController {

    // @Autowired
    // private StringRedisTemplate redisTemplate;

    // @GetMapping("/send")
    // public void verifyTokenGetMethod(@RequestHeader("Authorization") String
    // token) {
    // System.out.println("************** token in header get request /home
    // *************************");
    // System.out.println(token);
    // System.out.println("**************end*************************");

    // }
    // @Autowired
    // private FirebaseMessaging firebaseMessaging;

    // String fcmtoken ="dsatoken";

    // @PostMapping("/fcm-token")
    // public String verifyTokenGetMethod(@RequestBody Map<String, String> token) {
    //     try {
    //         // String fcmToken = token.get("fcmToken");
    //         // redisTemplate.opsForValue().set("fcmToken", fcmToken);
    //         fcmtoken = token.get("fcmToken");
    //         return "Fcm token saved successfully";
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return "Fcm token not saved";
    //     }
    // }

    // public void sendPushNotification(Device payload) throws JsonProcessingException, FirebaseMessagingException {
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.writeValueAsString(objectMapper);
    //     String jsonDataString = objectMapper.writeValueAsString(payload);

    //     Message message = Message.builder()
    //             .setToken(fcmtoken)
    //             // .setToken(redisTemplate.opsForValue().get("fcmToken"))
    //             .putData("jsonData", jsonDataString)
    //             .build();

    //     firebaseMessaging.send(message);
    // }

    // @PostMapping("/send")
    // public void verifyTokenPostMethod(@RequestHeader("Authorization") String
    // token) {
    // System.out.println("**************token in header post request
    // /home*************************");
    // System.out.println(token);
    // System.out.println("**************end*************************");
    // }

}

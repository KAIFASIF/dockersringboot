package com.kaif.dockersringboot.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    //     return "get sucess";
    // }

    // @PostMapping("/")
    // public String postData(@RequestBody Device data) {
    //     System.out.println("************************************");
    //     System.out.println(data);
    //     // service.save(data);
    //     System.out.println("************************************");

    //     return "post success";
    // }

    @GetMapping("/")
    public String testMethod(@RequestHeader("Authorization") String token) {

        System.out.println("**************aaaaaaaaa*************************");
        System.out.println(token);
        System.out.println("**************aaaaaaaaa*************************");
        // Here you can verify the token received from AWS IoT Core
        if (isValidToken(token)) {
            return "get success";
        } else {
            return "invalid token";
        }
    }

    @PostMapping("/")
    public String postData(@RequestHeader("Authorization") String token) {
        // Here you can verify the token received from AWS IoT Core

        System.out.println("**************bbbbbbbbbbb*************************");
        System.out.println(token);
        System.out.println("**************bbbbbbbbbbb*************************");
        if (isValidToken(token)) {
            return "post success";
        } else {
            return "invalid token";
        }
    }

    // Method to verify the token (you need to implement this logic)
    private boolean isValidToken(String token) {

        System.out.println("**************cccccccccccccccc*************************");
        System.out.println(token);
        System.out.println("**************cccccccccccccccc*************************");
        // Add your token validation logic here
        // For example, you can decode the token and check its validity
        // or compare it against a list of valid tokens
        // Return true if the token is valid, false otherwise
        return true; // Placeholder, replace with your logic
    }

}

package com.kaif.dockersringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderTokenController {

    @GetMapping("/")
    public String testMethod(@RequestHeader("Authorization") String token) {
        System.out.println("************** token in header get request  /home *************************");
        System.out.println(token);
        System.out.println("**************end*************************");

        return "get / success";
    }

    @PostMapping("/")
    public String postData(@RequestHeader("Authorization") String token) {
        System.out.println("**************token in header post request /home*************************");
        System.out.println(token);
        System.out.println("**************end*************************");
        return "post / success";
    }

}

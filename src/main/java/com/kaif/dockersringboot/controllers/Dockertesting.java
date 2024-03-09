package com.kaif.dockersringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dockertesting {

    @GetMapping("/")
    public String testMethod() {
        return "sucess";
    }

    
}

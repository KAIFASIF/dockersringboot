package com.kaif.dockersringboot.controllers;

import org.apache.catalina.connector.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaif.dockersringboot.entities.Device;

@RestController
public class Dockertesting {

    @GetMapping("/")
    public String testMethod() {
        return "get sucess";
    }

    @PostMapping("/") 
    public String postData(@RequestBody Device data) {
        System.out.println("************************************");
        System.out.println(data);
        System.out.println("************************************");
        return "post success";
    }

}

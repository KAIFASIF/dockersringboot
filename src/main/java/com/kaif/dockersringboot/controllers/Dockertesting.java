package com.kaif.dockersringboot.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaif.dockersringboot.entities.Device;
// import com.kaif.dockersringboot.repo.DeviceRepo;

@RestController
public class Dockertesting {

    // @Autowired
    // private DeviceRepo service;

    @GetMapping("/")
    public String testMethod() {
        return "get sucess";
    }

    @PostMapping("/")
    public String postData(@RequestBody Device data) {
        System.out.println("************************************");
        System.out.println(data);
        // service.save(data);
        System.out.println("************************************");

        return "post success";
    }

}

package com.kaif.dockersringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaif.dockersringboot.publisher.StringPublisherService;

@RestController
public class StringController {

    @Autowired
    private StringPublisherService stringPublisherService;

    @GetMapping("/string")
    public ResponseEntity<?> sendString() {
        try {

            for (int i = 0; i < 5; i++) {
                stringPublisherService.sendStringMessageToTopic("user: "+i);
            }

            return ResponseEntity.ok("String message published successfully ..");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError()
                    .build();
        }
    }

}

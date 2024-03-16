package com.kaif.dockersringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaif.dockersringboot.entities.Customer;
import com.kaif.dockersringboot.publisher.CustomerPublisherService;
import org.springframework.http.ResponseEntity;

@RestController
public class CustomerController {

    @Autowired
    private CustomerPublisherService customerPublisher;

    @PostMapping("/customer")
    public ResponseEntity<?> sendString(@RequestBody Customer customer) {
        try {

            for (int i = 0; i < 5; i++) {
                customerPublisher.sendCustomerMessageToTopic(customer);
            }

            return ResponseEntity.ok("customer json  published successfully ..");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError()
                    .build();
        }
    }

}

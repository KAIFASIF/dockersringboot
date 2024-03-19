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

    // @PostMapping("/customer")
    // public String sendString(@RequestBody Map<String, Object> payload) {
    // System.out.println("**************cccccccc*************************");
    // for (Map.Entry<String, Object> entry : payload.entrySet()) {
    // String key = entry.getKey();
    // Object value = entry.getValue();
    // System.out.println("Key: " + key + ", Value: " + value);
    // }
    // System.out.println("**************cccccccc*************************");
    // return "get /send success";
    // }

    @PostMapping("/send")
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
    // @PostMapping("/customer")
    // public ResponseEntity<?> sendString(@RequestBody Customer customer) {
    // try {

    // for (int i = 0; i < 5; i++) {
    // customerPublisher.sendCustomerMessageToTopic(customer);
    // }

    // return ResponseEntity.ok("customer json published successfully ..");
    // } catch (Exception ex) {
    // return ResponseEntity.internalServerError()
    // .build();
    // }
    // }

}

package com.kaif.dockersringboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

@SpringBootApplication
public class DockersringbootApplication {

    // @Bean
    // FirebaseMessaging firebaseMessagingBean() throws IOException {
    // var googleCredentials = GoogleCredentials
    // .fromStream(new
    // ClassPathResource("firebase-service-account.json").getInputStream());

    // var firebaseOptions =
    // FirebaseOptions.builder().setCredentials(googleCredentials).build();
    // var app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
    // return FirebaseMessaging.getInstance(app);
    // }

    @Bean
    FirebaseMessaging firebaseMessagingBean() throws IOException {
        // Check if FirebaseApp with the specified name already exists
        if (FirebaseApp.getApps().isEmpty() || FirebaseApp.getInstance("my-app") == null) {
            var googleCredentials = GoogleCredentials
                    .fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());

            var firebaseOptions = FirebaseOptions.builder().setCredentials(googleCredentials).build();
            FirebaseApp.initializeApp(firebaseOptions, "my-app");
        }
        return FirebaseMessaging.getInstance(FirebaseApp.getInstance("my-app"));
    }

    public static void main(String[] args) {
        SpringApplication.run(DockersringbootApplication.class, args);
    }

}

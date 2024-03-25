package com.kaif.dockersringboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

@SpringBootApplication
public class DockersringbootApplication {

    @Bean
    FirebaseMessaging firebaseMessagingBean() throws IOException {
        if (FirebaseApp.getApps().isEmpty() || FirebaseApp.getInstance("my-app") == null) {
            var googleCredentials = GoogleCredentials
                    .fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());

            var firebaseOptions = FirebaseOptions.builder().setCredentials(googleCredentials).build();
            FirebaseApp.initializeApp(firebaseOptions, "my-app");
        }
        return FirebaseMessaging.getInstance(FirebaseApp.getInstance("my-app"));
    }


    
    @Bean		
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedHeaders("*")
						.allowedMethods("*")
						.exposedHeaders("*");
			}	
		};
	}

    public static void main(String[] args) {
        SpringApplication.run(DockersringbootApplication.class, args);
    }

}

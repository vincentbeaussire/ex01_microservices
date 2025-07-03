package org.example.ex01_microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class Ex01MicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex01MicroservicesApplication.class, args);
    }

}

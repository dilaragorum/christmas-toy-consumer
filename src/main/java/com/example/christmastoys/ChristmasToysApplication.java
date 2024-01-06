package com.example.christmastoys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@EnableFeignClients
public class ChristmasToysApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChristmasToysApplication.class, args);
    }
}

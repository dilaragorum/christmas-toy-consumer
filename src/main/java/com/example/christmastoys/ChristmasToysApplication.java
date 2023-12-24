package com.example.christmastoys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ChristmasToysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChristmasToysApplication.class, args);
    }

}

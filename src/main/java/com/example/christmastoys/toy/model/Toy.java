package com.example.christmastoys.toy.model;


import lombok.Data;

import java.time.ZonedDateTime;


@Data
public class Toy {
    String id;
    String country;
    String address;
    String childName;
    String category;
    float weight;
    String sizeType;
    String message;
    int durationDay;
    String warehouse;
}

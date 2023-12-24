package com.example.christmastoys.event;

import lombok.Data;


@Data
public class ToyCreatedEvent {
    String id;
    String country;
    String address;
    String childName;
    String language;
    String toy;
    int toySize;
}

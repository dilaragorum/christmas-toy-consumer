package com.example.christmastoys.toy.model;

import lombok.Data;

@Data
public class ToyDTO {
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

    public void setSizeType() {
        if (weight < 10) {
            sizeType = "Small";
        } else if (weight > 10 && weight < 50) {
            sizeType = "Medium";
        } else {
            sizeType = "Large";
        }
    }

}

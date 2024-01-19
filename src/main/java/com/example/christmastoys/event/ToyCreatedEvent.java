package com.example.christmastoys.event;

import com.example.christmastoys.model.Toy;
import com.example.christmastoys.util.converter.JsonConverter;
import lombok.Data;

import static com.example.christmastoys.model.converter.MapStructConverter.MAPPER;


@Data
public class ToyCreatedEvent {
    String id;
    String country;
    String address;
    String childName;
    String category;
    double weight;

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }

    public Toy toToy() {
        return MAPPER.toyCreatedEventToToy(this);
    }
}

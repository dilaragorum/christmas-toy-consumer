package com.example.christmastoys.client.request;

import com.example.christmastoys.model.ToyDTO;
import com.example.christmastoys.util.converter.JsonConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateToyRequest {
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

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}

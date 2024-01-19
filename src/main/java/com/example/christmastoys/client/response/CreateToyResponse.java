package com.example.christmastoys.client.response;

import com.example.christmastoys.util.converter.JsonConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateToyResponse {
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

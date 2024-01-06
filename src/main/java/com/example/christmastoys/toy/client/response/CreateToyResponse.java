package com.example.christmastoys.toy.client.response;

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
    private String id;

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}

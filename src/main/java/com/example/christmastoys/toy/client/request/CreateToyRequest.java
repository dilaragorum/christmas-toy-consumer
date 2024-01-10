package com.example.christmastoys.toy.client.request;

import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.model.ToyDTO;
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
    ToyDTO toy;

    @Override
    public String toString() {
        return JsonConverter.objectToJson(this);
    }
}

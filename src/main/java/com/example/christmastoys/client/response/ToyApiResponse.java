package com.example.christmastoys.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToyApiResponse<T> {
    private T data;
    private String errorMessage;
    private boolean success;
}

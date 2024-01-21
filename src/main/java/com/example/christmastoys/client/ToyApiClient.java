package com.example.christmastoys.client;

import com.example.christmastoys.client.request.CreateToyRequest;
import com.example.christmastoys.client.response.CreateToyResponse;
import com.example.christmastoys.client.response.ToyApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "toyApiClient", url = "http://localhost:8080")
interface ToyApiClient {
    @PostMapping(value = "/api/v1/toys", consumes = "application/json")
    ResponseEntity<ToyApiResponse<Void>> createToy(CreateToyRequest request);
}

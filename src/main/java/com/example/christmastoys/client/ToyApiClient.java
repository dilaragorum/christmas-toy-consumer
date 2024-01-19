package com.example.christmastoys.client;

import com.example.christmastoys.client.request.CreateToyRequest;
import com.example.christmastoys.client.response.CreateToyResponse;
import com.example.christmastoys.client.response.ToyApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "toyApiClient", url = "http://localhost:8080")
interface ToyApiClient {
    @PostMapping("/api/v1/toys")
    ToyApiResponse<CreateToyResponse> createToy(@RequestBody CreateToyRequest request);
}

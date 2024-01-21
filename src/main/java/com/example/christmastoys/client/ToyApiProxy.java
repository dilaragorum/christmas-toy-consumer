package com.example.christmastoys.client;

import com.example.christmastoys.client.exception.CreateToyException;
import com.example.christmastoys.client.request.CreateToyRequest;
import com.example.christmastoys.client.response.CreateToyResponse;
import com.example.christmastoys.client.response.ToyApiResponse;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

@RequiredArgsConstructor

@Slf4j
public class ToyApiProxy {
    private final ToyApiClient toyApiClient;

    public void createToy(CreateToyRequest request) {

        log.info("ToyApi createToy request sending. Request: {}", request);
        ResponseEntity<ToyApiResponse<Void>> response;
        try {
            response = toyApiClient.createToy(request);

        } catch (Exception e) {
            log.error("Error occurred while sending createToy request to ToyApi. Error: {}", e.getMessage());
            throw new CreateToyException(e.getMessage());
        }

        if (!Objects.requireNonNull(response.getBody()).isSuccess() || StringUtils.isNotBlank(response.getBody().getErrorMessage())) {
            log.error("ToyApi createTracking service responded as error response. Error: {}", response.getBody().getErrorMessage());
            throw new CreateToyException(response.getBody().getErrorMessage());
        }

        log.info("TrackingApi createTracking responded successfully. ");
    }
}

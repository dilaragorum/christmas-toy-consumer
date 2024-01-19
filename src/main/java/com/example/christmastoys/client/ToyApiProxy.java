package com.example.christmastoys.client;

import com.example.christmastoys.client.exception.CreateToyException;
import com.example.christmastoys.client.request.CreateToyRequest;
import com.example.christmastoys.client.response.CreateToyResponse;
import com.example.christmastoys.client.response.ToyApiResponse;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor

@Slf4j
public class ToyApiProxy {
    private final ToyApiClient toyApiClient;

    public CreateToyResponse createToy(CreateToyRequest request) {

        log.info("ToyApi createToy request sending. Request: {}", request);
        ToyApiResponse<CreateToyResponse> response;
        try {
            response = toyApiClient.createToy(request);

        } catch (Exception e) {
            log.error("Error occurred while sending createToy request to ToyApi. Error: {}", e.getMessage());
            throw new CreateToyException(e.getMessage());
        }

        if (!response.isSuccess() || StringUtils.isNotBlank(response.getErrorMessage())) {
            log.error("ToyApi createTracking service responded as error response. Error: {}", response.getErrorMessage());
            throw new CreateToyException(response.getErrorMessage());
        }

        if (response.getData() == null) {
            log.error("TrackingApi createTracking service responded as null response.");
            throw new CreateToyException("TrackingApi createTracking service responded as null response.");
        }


        log.info("TrackingApi createTracking responded successfully. Response: {}", response.getData());
        return response.getData();
    }
}

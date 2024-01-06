package com.example.christmastoys.util.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ObjectMapperInitializer implements InitializingBean {
    private final ObjectMapper objectMapper;
    private static ObjectMapper instance;

    public void afterPropertiesSet() {
        instance = this.objectMapper;
    }

    public static ObjectMapper get() {
        return (ObjectMapper) Objects.requireNonNullElse(instance, ObjectMapperConfiguration.createNewDeliveryObjectMapper());
    }

    public ObjectMapperInitializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}

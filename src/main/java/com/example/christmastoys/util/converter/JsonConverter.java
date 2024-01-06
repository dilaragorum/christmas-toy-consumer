package com.example.christmastoys.util.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonConverter {
    private static final Logger log = LoggerFactory.getLogger(JsonConverter.class);

    public static String objectToJson(Object object) {
        if (object != null && String.class.isAssignableFrom(object.getClass())) {
            return (String)object;
        } else {
            ObjectMapper objectMapper = ObjectMapperInitializer.get();

            try {
                return objectMapper.writeValueAsString(object);
            } catch (JsonProcessingException var3) {
                log.error("Couldn't serialize the object. Exception: {}", var3.getMessage());
                throw new RuntimeException("Couldn't serialize the object");
            }
        }
    }

    public static <T> T jsonToObject(String json, Class<T> classType) {
        ObjectMapper objectMapper = ObjectMapperInitializer.get();

        try {
            return objectMapper.readValue(json, classType);
        } catch (JsonProcessingException var4) {
            log.error("Couldn't deserialize the object. Exception: {}", var4.getMessage());
            throw new RuntimeException("Couldn't deserialize the object");
        }
    }

    private JsonConverter() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

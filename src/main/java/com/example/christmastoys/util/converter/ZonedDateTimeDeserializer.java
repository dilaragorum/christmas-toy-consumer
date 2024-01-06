package com.example.christmastoys.util.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
    public ZonedDateTimeDeserializer() {
    }

    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        try {
            return ZonedDateTime.parse(jsonParser.getText());
        } catch (Exception var6) {
            try {
                LocalDateTime ldt = LocalDateTime.parse(jsonParser.getText());
                return ldt.atZone(ZoneOffset.UTC);
            } catch (Exception var5) {
                if (jsonParser.getText().length() == 10) {
                    return Instant.ofEpochSecond(Long.parseLong(jsonParser.getText())).atZone(ZoneOffset.UTC);
                } else if (jsonParser.getText().length() == 13) {
                    return Instant.ofEpochMilli(Long.parseLong(jsonParser.getText())).atZone(ZoneOffset.UTC);
                } else {
                    throw new IOException(String.format("Wrong timestamp value: %s, Request field: %s", jsonParser.getText(), jsonParser.getCurrentName()));
                }
            }
        }
    }
}

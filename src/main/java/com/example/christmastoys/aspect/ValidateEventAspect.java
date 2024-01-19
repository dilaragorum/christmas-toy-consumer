package com.example.christmastoys.aspect;


import com.example.christmastoys.event.ToyCreatedEvent;
import com.example.christmastoys.exception.BannedToyException;
import com.example.christmastoys.exception.SkipException;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;
import java.util.Objects;

@Aspect
@EnableAspectJAutoProxy
@Configuration
@Slf4j
public class ValidateEventAspect {
    @Value("${banned-toy-list}")
    private List<String> bannedToyList;

    private final Gson gson = new Gson();

    @SneakyThrows
    @Around("@annotation(com.example.christmastoys.annotation.ValidateToyCreatedEvent)")
    public ToyCreatedEvent validateToyCreatedEvent(ProceedingJoinPoint joinPoint) {
        String incomingJson = (String) joinPoint.getArgs()[0];
        ToyCreatedEvent event = gson.fromJson(incomingJson, ToyCreatedEvent.class);

        log.info("Validating ToyCreatedEvent: {}", event);

        if (Objects.isNull(event.getId())) {
            log.warn("ToyCreatedEvent will ignore due to toy id is null");
            throw new SkipException("ToyCreatedEvent is skipping");
        }

        if (event.getWeight() <= 0.0) {
            log.warn("Weight should not be less than and equal 0 therefore ToyCreatedEvent will be skipping");
            throw new SkipException("ToyCreatedEvent is skipping");
        }

        if (bannedToyList.contains(event.getCategory())) {
            throw new BannedToyException(String.format("%s banned toy. Say child(id: %s) play more beautiful toy", event.getCategory(), event.getId()));
        }

        joinPoint.proceed();

        return event;
    }
}

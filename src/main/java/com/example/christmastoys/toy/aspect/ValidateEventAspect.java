package com.example.christmastoys.toy.aspect;


import com.example.christmastoys.toy.ToyCreatedEvent;
import com.example.christmastoys.toy.exception.BannedToyException;
import com.example.christmastoys.toy.exception.SkipException;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@EnableAspectJAutoProxy
@Configuration
@Slf4j
public class ValidateEventAspect {
    @Value("${banned-toy-list}")
    private String[] bannedToyList;

    @SneakyThrows
    @Around("@annotation(com.example.christmastoys.toy.annotation.ValidateToyCreatedEvent)")
    public ToyCreatedEvent validateDeliveredEvent(ProceedingJoinPoint joinPoint) {
        Gson gson = new Gson();
        ToyCreatedEvent event = gson.fromJson((String) joinPoint.getArgs()[0], ToyCreatedEvent.class);

        log.info("Validating ToyCreatedEvent: {}", event);

        if (Objects.isNull(event.getId())) {
            log.warn("ToyCreatedEvent will ignore due to toy id is null");
            throw new SkipException("ToyCreatedEvent is skipping");
        }

        if (event.getWeight() <= 0.0) {
            log.warn("Weight should not be less than and equal 0 therefore ToyCreatedEvent will be skipping");
            throw new SkipException("ToyCreatedEvent is skipping");
        }

        if (Arrays.asList(bannedToyList).contains(event.getCategory())) {
            throw new BannedToyException(String.format("%s banned toy. Say child(id: %s) play more beautiful toy", event.getCategory(), event.getId()));
        }

        joinPoint.proceed();

        return event;
    }
}

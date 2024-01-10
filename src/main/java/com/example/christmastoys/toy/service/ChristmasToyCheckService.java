package com.example.christmastoys.toy.service;

import com.example.christmastoys.toy.client.ToyApiProxy;
import com.example.christmastoys.toy.client.request.CreateToyRequest;
import com.example.christmastoys.toy.client.response.CreateToyResponse;
import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.model.ToyDTO;
import com.example.christmastoys.toy.service.checker.Checker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.christmastoys.toy.model.converter.MapStructConverter.MAPPER;


@Slf4j
@Component
@RequiredArgsConstructor
public class ChristmasToyCheckService {
    private final List<Checker> checkers;

    @Autowired
    private ToyApiProxy toyApiProxy;

    public void processEvent(Toy toy) {
        ToyDTO toyDTO = MAPPER.toyToDTO(toy);

        for (Checker checker : checkers) {
            toyDTO = checker.process(toyDTO);
        }

        CreateToyResponse toyRes = toyApiProxy.createToy(CreateToyRequest.builder().toy(toyDTO).build());

        log.info("Toy is successfully created : {}", toyRes.toString());
    }
}
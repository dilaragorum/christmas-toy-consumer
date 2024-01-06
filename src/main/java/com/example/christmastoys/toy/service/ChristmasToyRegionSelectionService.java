package com.example.christmastoys.toy.service;

import com.example.christmastoys.toy.client.ToyApiProxy;
import com.example.christmastoys.toy.client.request.CreateToyRequest;
import com.example.christmastoys.toy.client.response.CreateToyResponse;
import com.example.christmastoys.toy.exception.BannedToyException;
import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.service.selector.Selector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class ChristmasToyRegionSelectionService {
    private final List<Selector> selectors;

    @Autowired
    private ToyApiProxy toyApiProxy;

    public void processEvent(Toy toy) {
        for (Selector selector : selectors) {
            toy = selector.check(toy);
        }

         /*Toy result = selectors.stream()
                .reduce(toy, (currentToy, selector) -> selector.check(currentToy), (toy1, toy2) -> toy2); */

        CreateToyResponse toyRes = toyApiProxy.createToy(CreateToyRequest.builder().toy(toy).build());

        log.info("Toy is successfully created : {}", toyRes.toString());
    }
}

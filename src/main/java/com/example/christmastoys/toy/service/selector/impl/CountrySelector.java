package com.example.christmastoys.toy.service.selector.impl;

import com.example.christmastoys.toy.exception.InvalidCountryException;
import com.example.christmastoys.toy.model.GiftMessage;
import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.service.selector.Selector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.example.christmastoys.toy.service.rule.RegionRuleOrder.COUNTRY_SELECTOR;


@Slf4j
@Component
@RequiredArgsConstructor
@Order(COUNTRY_SELECTOR)
public class CountrySelector implements Selector {

    @Value("${country-list}")
    private String[] countryList;


    @Override
    public Toy check(Toy toy) {
        if (!isEligibleCountry(toy.getCountry())) {
            throw new InvalidCountryException(String.format("We have no service for %s", toy.getCountry()));
        }

        String noteInGiftBox = getNoteInGiftBox(toy.getCountry());
        toy.setMessage(noteInGiftBox);

        return toy;

    }

    public boolean isEligibleCountry(String country) {
        return Arrays.asList(countryList).contains(country);
    }

    public String getNoteInGiftBox(String country) {
        return GiftMessage.countryToMessage.get(country);
    }
}

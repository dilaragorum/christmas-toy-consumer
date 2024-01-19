package com.example.christmastoys.service.checker.impl;

import com.example.christmastoys.exception.InvalidCountryException;
import com.example.christmastoys.model.GiftMessage;
import com.example.christmastoys.model.ToyDTO;
import com.example.christmastoys.service.checker.Checker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.christmastoys.service.rule.RegionRuleOrder.COUNTRY_SELECTOR;


@Slf4j
@Component
@RequiredArgsConstructor
@Order(COUNTRY_SELECTOR)
public class CountryCheck implements Checker {

    @Value("${country-list}")
    private List<String> countryList;

    @Override
    public ToyDTO process(ToyDTO toyDTO) {
        String country = toyDTO.getCountry();

        if (!isEligibleCountry(country)) {
            throw new InvalidCountryException(String.format("We have no service for %s", toyDTO.getCountry()));
        }

        toyDTO.setMessage(getNoteInGiftBox(country));

        return toyDTO;

    }

    public boolean isEligibleCountry(String country) {
        return countryList.contains(country);
    }

    public String getNoteInGiftBox(String country) {
        return GiftMessage.countryToMessage.get(country);
    }
}

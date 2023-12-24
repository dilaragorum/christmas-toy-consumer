package com.example.christmastoys.service.selector.impl;

import com.example.christmastoys.event.ToyCreatedEvent;
import com.example.christmastoys.service.selector.RegionSelector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.example.christmastoys.service.rule.RegionRuleOrder.EUROPE_SELECTOR;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(EUROPE_SELECTOR)
public class EuropeSelector implements RegionSelector {

    @Value("${europe-country-list}")
    private String[] europeCountryList;

    @Override
    public boolean isEligible(ToyCreatedEvent event) {
        return Arrays.asList(europeCountryList).contains(event.getCountry());
    }

    @Override
    public String dispatchRegion(ToyCreatedEvent event) {
        return "EuropeSelector'a hoşgeldin.";
    }
}

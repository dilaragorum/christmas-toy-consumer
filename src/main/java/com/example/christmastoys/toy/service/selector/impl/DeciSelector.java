package com.example.christmastoys.toy.service.selector.impl;

import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.service.selector.Selector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.example.christmastoys.toy.service.rule.RegionRuleOrder.DECI_SELECTOR;


@Slf4j
@Component
@RequiredArgsConstructor
@Order(DECI_SELECTOR)
public class DeciSelector implements Selector {
    @Override
    public Toy check(Toy toy) {
        String sizeType = getSizeType(toy.getWeight());
        toy.setSizeType(sizeType);
        return toy;
    }

    private String getSizeType(float weight) {
        if (weight < 10) {
            return "Small";
        } else if (weight > 10 && weight < 50) {
            return "Medium";
        } else {
            return "Large";
        }
    }
}

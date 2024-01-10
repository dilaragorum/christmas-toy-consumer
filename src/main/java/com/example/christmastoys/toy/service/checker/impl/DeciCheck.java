package com.example.christmastoys.toy.service.checker.impl;

import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.model.ToyDTO;
import com.example.christmastoys.toy.service.checker.Checker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.example.christmastoys.toy.model.converter.MapStructConverter.MAPPER;
import static com.example.christmastoys.toy.service.rule.RegionRuleOrder.DECI_SELECTOR;


@Slf4j
@Component
@RequiredArgsConstructor
@Order(DECI_SELECTOR)
public class DeciCheck implements Checker {

    @Override
    public ToyDTO process(ToyDTO toyDTO) {
        toyDTO.setSizeType();

        return toyDTO;
    }
}

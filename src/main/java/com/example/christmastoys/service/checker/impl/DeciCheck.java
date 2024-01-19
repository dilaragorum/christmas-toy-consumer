package com.example.christmastoys.service.checker.impl;

import com.example.christmastoys.model.ToyDTO;
import com.example.christmastoys.service.checker.Checker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.example.christmastoys.service.rule.RegionRuleOrder.DECI_SELECTOR;


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

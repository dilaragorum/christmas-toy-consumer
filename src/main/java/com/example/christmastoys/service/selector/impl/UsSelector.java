package com.example.christmastoys.service.selector.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import static com.example.christmastoys.service.rule.RegionRuleOrder.US_SELECTOR;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(US_SELECTOR)
public class UsSelector {
}

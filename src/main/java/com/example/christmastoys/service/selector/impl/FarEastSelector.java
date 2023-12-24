package com.example.christmastoys.service.selector.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.example.christmastoys.service.rule.RegionRuleOrder.FAR_EAST_SELECTOR;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(FAR_EAST_SELECTOR)
public class FarEastSelector {
}

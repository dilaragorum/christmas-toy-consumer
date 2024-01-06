package com.example.christmastoys.toy.service.rule;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

public final class RegionRuleOrder {
    public static final int COUNTRY_SELECTOR = HIGHEST_PRECEDENCE;
    public static final int DECI_SELECTOR = HIGHEST_PRECEDENCE + 10;
    public static final int WAREHOUSE_SELECTOR = HIGHEST_PRECEDENCE + 20;
}

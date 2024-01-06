package com.example.christmastoys.toy.service.selector.impl;

import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.model.Warehouse;
import com.example.christmastoys.toy.service.selector.Selector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import static com.example.christmastoys.toy.service.rule.RegionRuleOrder.WAREHOUSE_SELECTOR;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(WAREHOUSE_SELECTOR)
public class WarehouseSelector implements Selector {
    @Override
    public Toy check(Toy toy) {
        String warehouse = getWarehouse(toy.getCountry());
        int durationDay = getDurationDay(warehouse, toy.getCountry());
        toy.setWarehouse(warehouse);
        toy.setDurationDay(durationDay);

        return toy;
    }

    private int getDurationDay(String warehouse, String country) {
        return Warehouse.warehouseToDurationDay.get(country).get(warehouse);
    }

    private String getWarehouse(String country) {
       return Warehouse.countryToWarehouse.get(country);
    }
}

package com.example.christmastoys.toy.service.checker.impl;

import com.example.christmastoys.toy.model.Toy;
import com.example.christmastoys.toy.model.ToyDTO;
import com.example.christmastoys.toy.model.Warehouse;
import com.example.christmastoys.toy.service.checker.Checker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.example.christmastoys.toy.model.converter.MapStructConverter.MAPPER;
import static com.example.christmastoys.toy.service.rule.RegionRuleOrder.WAREHOUSE_SELECTOR;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(WAREHOUSE_SELECTOR)
public class WarehouseCheck implements Checker {
    @Override
    public ToyDTO process(ToyDTO toyDTO) {
        String country = toyDTO.getCountry();

        String warehouse = getWarehouse(country);
        int durationDay = getDurationDay(warehouse, country);

        toyDTO.setWarehouse(warehouse);
        toyDTO.setDurationDay(durationDay);

        return toyDTO;
    }

    private int getDurationDay(String warehouse, String country) {
        return Warehouse.warehouseToDurationDay.get(country).get(warehouse);
    }

    private String getWarehouse(String country) {
       return Warehouse.countryToWarehouse.get(country);
    }
}

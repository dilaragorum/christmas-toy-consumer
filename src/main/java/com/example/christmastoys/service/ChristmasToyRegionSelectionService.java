package com.example.christmastoys.service;

import com.example.christmastoys.event.ToyCreatedEvent;
import com.example.christmastoys.service.selector.RegionSelector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
@Component
public class ChristmasToyRegionSelectionService {
    private final Supplier<Stream<RegionSelector>> christmasToyRegionSelectorSupplier;

    public ChristmasToyRegionSelectionService(List<RegionSelector> christmasToyRegionSelectors) {
        this.christmasToyRegionSelectorSupplier = christmasToyRegionSelectors::stream;
    }

    public void processEvent(ToyCreatedEvent event) {
        List<String> regions = this.christmasToyRegionSelectorSupplier.get().filter(regionSelector -> regionSelector.isEligible(event)).map(selector -> selector.dispatchRegion(event)).collect(Collectors.toList());
        log.info(regions.get(0));
    }

}

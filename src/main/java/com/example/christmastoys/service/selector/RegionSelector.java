package com.example.christmastoys.service.selector;

import com.example.christmastoys.event.ToyCreatedEvent;

public interface RegionSelector {
    boolean isEligible(ToyCreatedEvent event);
    String dispatchRegion(ToyCreatedEvent event);
}

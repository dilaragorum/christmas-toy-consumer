package com.example.christmastoys.toy.model;

import java.util.Map;

public class Warehouse {
    public static final Map<String, String> countryToWarehouse = Map.of(
            "England", "Poland",
            "France", "Poland",
            "Poland", "Poland",
            "China", "Chinese",
            "Tailand", "Chinese",
            "Turkey", "Poland",
            "Japan", "Chinese"
    );

    public static final Map<String, Map<String, Integer>> warehouseToDurationDay;

    static {
        warehouseToDurationDay = Map.ofEntries(
                Map.entry("England", Map.of("Poland", 2)),
                Map.entry("France", Map.of("Poland", 2)),
                Map.entry("Poland", Map.of("Poland", 1)),
                Map.entry("China", Map.of("Chinese", 1)),
                Map.entry("Tailand", Map.of("Chinese", 4)),
                Map.entry("Turkey", Map.of("Poland", 2)),
                Map.entry("Japan", Map.of("Chinese", 2))
        );
    }
}

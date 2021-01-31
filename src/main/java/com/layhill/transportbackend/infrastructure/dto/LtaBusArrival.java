package com.layhill.transportbackend.infrastructure.dto;

import java.util.List;

public class LtaBusArrival {
    private String busStopCode;
    private List<BusService> services;

    public String getBusStopCode() {
        return busStopCode;
    }

    public List<BusService> getServices() {
        return services;
    }
}

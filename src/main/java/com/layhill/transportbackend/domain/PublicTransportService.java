package com.layhill.transportbackend.domain;

import com.layhill.transportbackend.infrastructure.adapters.LtaServiceAdapter;


public class PublicTransportService {


    private LtaServiceAdapter ltaServiceAdapter;

    public PublicTransportService(LtaServiceAdapter ltaServiceAdapter) {
        this.ltaServiceAdapter = ltaServiceAdapter;
    }

    public BusStop getBusServiceForBusStop(String busStopCode) {
        return ltaServiceAdapter.getBusArrival(busStopCode);
    }
}

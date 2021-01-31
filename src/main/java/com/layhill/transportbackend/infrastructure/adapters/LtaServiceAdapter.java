package com.layhill.transportbackend.infrastructure.adapters;

import com.layhill.transportbackend.domain.BusStop;

public interface LtaServiceAdapter {

    BusStop getBusArrival(String busStopCode);
}

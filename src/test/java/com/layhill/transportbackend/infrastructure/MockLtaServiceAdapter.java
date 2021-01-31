package com.layhill.transportbackend.infrastructure;

import com.layhill.transportbackend.domain.BusStop;
import com.layhill.transportbackend.infrastructure.adapters.LtaServiceAdapter;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.test.annotation.MockBean;

import javax.inject.Singleton;

@Singleton
public class MockLtaServiceAdapter implements LtaServiceAdapter {

    @Override
    public BusStop getBusArrival(String busStopCode) {
        return new BusStop("12345", "TestName");
    }
}

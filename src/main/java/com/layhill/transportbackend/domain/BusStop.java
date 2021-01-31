package com.layhill.transportbackend.domain;

public class BusStop {

    private String busStopCode;
    private String busStopName;

    public BusStop(String busStopCode, String busStopName) {
        this.busStopCode = busStopCode;
        this.busStopName = busStopName;
    }

    public String getBusStopCode() {
        return busStopCode;
    }

    public String getBusStopName() {
        return busStopName;
    }
}

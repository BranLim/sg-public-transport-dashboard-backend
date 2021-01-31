package com.layhill.transportbackend.interfaces.DTO;

public class BusStopDTO {

    private String busStopCode;
    private String busStopName;

    protected BusStopDTO() {
    }

    public BusStopDTO(String busStopCode, String busStopName) {
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

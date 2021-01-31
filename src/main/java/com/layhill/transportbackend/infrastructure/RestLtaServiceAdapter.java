package com.layhill.transportbackend.infrastructure;

import com.layhill.transportbackend.domain.BusStop;
import com.layhill.transportbackend.infrastructure.adapters.LtaServiceAdapter;
import com.layhill.transportbackend.infrastructure.dto.LtaBusArrival;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.uri.UriBuilder;

import javax.inject.Inject;
import java.net.URI;

public class RestLtaServiceAdapter implements LtaServiceAdapter {

    @Inject
    private RxHttpClient httpClient;

    private final String ltaApiService = "http://datamall2.mytransport.sg/ltaodataservice";
    private final String accountKey = "";


    @Override
    public BusStop getBusArrival(String busStopCode) {

        URI busArrivalApi = UriBuilder.of(ltaApiService + "/BusArrivalv2")
                .queryParam("BusStopCode", busStopCode)
                .build();
        MutableHttpRequest getRequest = HttpRequest.GET(busArrivalApi.toString()).header("AccountKey", accountKey);
        HttpResponse<LtaBusArrival> response = httpClient.toBlocking().exchange(getRequest, LtaBusArrival.class);
        if (response.code() == 200) {
            LtaBusArrival arrival = response.body();
        }

        return new BusStop("","");
    }


}

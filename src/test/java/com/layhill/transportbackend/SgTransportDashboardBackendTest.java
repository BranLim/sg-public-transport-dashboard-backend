package com.layhill.transportbackend;

import com.layhill.transportbackend.interfaces.DTO.BusStopDTO;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

import static io.micronaut.http.HttpRequest.GET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@MicronautTest
class SgTransportDashboardBackendTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/")
    private RxHttpClient client;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testBusStopResourceShouldReturn200() {
        HttpResponse response = client.toBlocking().exchange(GET("/api"));
        assertThat(response.code()).isEqualTo(200);
    }

    @Test
    void testApiShouldReturnValidResponseWhenGivenValidQueryString() {
        HttpResponse<BusStopDTO> response = client.toBlocking().exchange(GET("/api/busstops?busStopCode=12345"), BusStopDTO.class);
        assertThat(response.code()).isEqualTo(200);
        assertThat(response.body()).isNotNull();
    }

    @Test
    void testApiShouldReturnErrorResponseWhenNotGivenValidQueryString() {

        assertThatThrownBy(() -> {
            HttpResponse<BusStopDTO> response = client.toBlocking().exchange(GET("/api/busstops"), BusStopDTO.class);
        }).isInstanceOf(HttpClientResponseException.class);

    }
}

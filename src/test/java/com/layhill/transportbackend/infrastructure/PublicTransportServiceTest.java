package com.layhill.transportbackend.infrastructure;

import com.layhill.transportbackend.domain.BusStop;
import com.layhill.transportbackend.domain.PublicTransportService;
import com.layhill.transportbackend.infrastructure.adapters.LtaServiceAdapter;
import io.micronaut.context.annotation.Primary;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class PublicTransportServiceTest {

    @Inject
    LtaServiceAdapter ltaServiceAdapter;

    @Test
    void testShouldReturnBusStopDetailsWhenGivenValidBusStopCode() {
        when(ltaServiceAdapter.getBusArrival("12345")).thenReturn(new BusStop("12345", "TestBusStop"));
        PublicTransportService publicTransportService = new PublicTransportService(ltaServiceAdapter);
        BusStop busStop =publicTransportService.getBusServiceForBusStop("12345");
        assertThat(busStop).isNotNull();
        assertThat(busStop.getBusStopCode()).isEqualTo("12345");

    }

    @Primary
    @MockBean(MockLtaServiceAdapter.class)
    LtaServiceAdapter ltaServiceAdapter(){
        return mock(LtaServiceAdapter.class);
    }

}

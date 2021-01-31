package com.layhill.transportbackend.interfaces;

import com.layhill.transportbackend.interfaces.DTO.BusStopDTO;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import javax.annotation.Nullable;

@Controller("/api")
public class BusStopResource {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String index(){
        return "";
    }


    @Get("/busstops{?busStopCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<BusStopDTO> getBusStop(@Nullable String busStopCode){
        if (StringUtils.isEmpty(busStopCode)){
            return HttpResponse.badRequest();
        }

        return HttpResponse.ok(new BusStopDTO("12345", "TestName"));
    }

}

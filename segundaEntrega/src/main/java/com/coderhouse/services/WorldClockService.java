package com.coderhouse.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Service
public class WorldClockService {

    private final String API_URL = "http://worldclockapi.com/api/json/utc/now";

    public ZonedDateTime obtenerFechaActual() {
        RestTemplate restTemplate = new RestTemplate();
      
        String response = restTemplate.getForObject(API_URL, String.class);
        String fechaString = response.substring(response.indexOf("\"currentDateTime\":\"") + 18, response.indexOf("\",\"utcOffset\""));
        
        return ZonedDateTime.parse(fechaString);
    }
}

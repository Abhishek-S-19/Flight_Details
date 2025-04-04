package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/findFlightFrom/{source}/to/{destination}/on/{date}")
    public ResponseEntity<List<Flight>> findBySourceDestinationAndDate(
            @PathVariable("source") String source,
            @PathVariable("destination") String destination,
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok().body(flightService.findBySourceDestinationAndDate(source, destination, date));
    }

    @GetMapping("/findFlightFrom/{source}/on/{date}")
    public ResponseEntity<List<Flight>> findBySourceAndDate(
            @PathVariable("source") String source,
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok().body(flightService.findBySourceAndDate(source, date));
    }

}

package com.example.demo;


import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public FlightService(final JPAStreamer jpaStreamer){
        this.jpaStreamer = jpaStreamer;
    }

    public List<Flight> findBySourceDestinationAndDate(String source, String destination, LocalDate date){
        return jpaStreamer.stream(Flight.class)
                .filter((flight) -> (flight.getSource().equals(source))
                        && (flight.getDestination().equals(destination))
                        && (flight.getDepartureDateTime().toLocalDate().isEqual(date)))
                .collect(Collectors.toList());
    }

    public List<Flight> findBySourceAndDate(String source, LocalDate date) {
        return jpaStreamer.stream(Flight.class)
                .filter((flight) -> (flight.getSource().equals(source))
                        && (flight.getDepartureDateTime().toLocalDate().isEqual(date)))
                .collect(Collectors.toList());
    }

}

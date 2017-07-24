package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.airline.model.AirlineResourceDisassembler;
import ninja.harmless.vishnu.airplane.model.AirplaneResourceDisassembler;
import ninja.harmless.vishnu.airport.model.AirportResourceDisassembler;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassembler;
import ninja.harmless.vishnu.common.resource.FlightResource;
import ninja.harmless.vishnu.flight.model.entity.Flight;
import ninja.harmless.vishnu.flight.model.entity.FlightStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class FlightResourceDisassembler implements ResourceDisassembler<FlightResource, Flight> {
    @Autowired
    AirplaneResourceDisassembler airplaneResourceDisassembler;

    @Autowired
    AirportResourceDisassembler airportResourceDisassembler;

    @Autowired
    AirlineResourceDisassembler airlineResourceDisassembler;

    @Override
    public Flight fromResource(FlightResource resource) {
      Optional<FlightResource> optional = Optional.ofNullable(resource);
      FlightResource flightResource = optional.orElseThrow(ResourceNotFoundException::new);
      return Flight.builder()
        .flightNumber(flightResource.getFlightNumber())
        .airplane(airplaneResourceDisassembler.fromResource(flightResource.getAirplane()))
        .arrivalTime(LocalDateTime.parse(flightResource.getArrivalTime()))
        .departureTime(LocalDateTime.parse(flightResource.getDepartureTime()))
        .from(airportResourceDisassembler.fromResource(flightResource.getFrom()))
        .to(airportResourceDisassembler.fromResource(flightResource.getTo()))
        .operator(airlineResourceDisassembler.fromResource(flightResource.getOperator()))
        .status(FlightStatus.valueOf(flightResource.getStatus())).build();
    }
}

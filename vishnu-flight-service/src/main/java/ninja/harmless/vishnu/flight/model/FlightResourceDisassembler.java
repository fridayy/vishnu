package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.airline.model.AirlineRepository;
import ninja.harmless.vishnu.airline.model.entity.Airline;
import ninja.harmless.vishnu.airplane.model.AirplaneRepository;
import ninja.harmless.vishnu.airplane.model.entity.Airplane;
import ninja.harmless.vishnu.airport.model.AirportRepository;
import ninja.harmless.vishnu.airport.model.entity.Airport;
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
    private AirportRepository airportRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public Flight fromResource(FlightResource resource) {
      Optional<FlightResource> optional = Optional.ofNullable(resource);
      FlightResource flightResource = optional.orElseThrow(ResourceNotFoundException::new);
      Optional<Airport> from = airportRepository.findAirportByIataCode(flightResource.getFrom().getIataCode());
      Optional<Airport> to = airportRepository.findAirportByIataCode(flightResource.getTo().getIataCode());
      Optional<Airplane> airplane = airplaneRepository.findAirplaneByTypeDeclaration(flightResource.getAirplane().getTypeDeclaration());
      Optional<Airline> airline = airlineRepository.findAirlineByName(flightResource.getOperator().getName());

      return Flight.builder()
        .flightNumber(flightResource.getFlightNumber())
        .airplane(airplane.orElseThrow(ResourceNotFoundException::new))
        .arrivalTime(LocalDateTime.parse(flightResource.getArrivalTime()))
        .departureTime(LocalDateTime.parse(flightResource.getDepartureTime()))
        .from(from.orElseThrow(ResourceNotFoundException::new))
        .to(to.orElseThrow(ResourceNotFoundException::new))
        .operator(airline.orElseThrow(ResourceNotFoundException::new))
        .status(FlightStatus.valueOf(flightResource.getStatus().toUpperCase())).build();
    }
}

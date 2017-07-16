package ninja.harmless.vishnu.common.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class FlightResource extends ResourceSupport {
    @JsonIgnore
    private final AirportResource from;

    @JsonIgnore
    private final AirportResource to;

    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final String flightNumber;

    @JsonIgnore
    private final AirplaneResource airplane;

    @JsonIgnore
    private final AirlineResource operator;

    private UUID uuid;

    public FlightResource(AirportResource from, AirportResource to, LocalDateTime departureTime, LocalDateTime arrivalTime, String flightNumber, AirplaneResource airplane, AirlineResource operator, UUID uuid) {
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.operator = operator;
        this.uuid = uuid;
    }

    public AirportResource getFrom() {
        return from;
    }

    public AirportResource getTo() {
        return to;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public AirplaneResource getAirplane() {
        return airplane;
    }

    public AirlineResource getOperator() {
        return operator;
    }

    public UUID getUuid() {
        return uuid;
    }
}

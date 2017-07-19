package ninja.harmless.vishnu.common.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class FlightResource extends ResourceSupport {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AirportResource from;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AirportResource to;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AirplaneResource airplane;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AirlineResource operator;

    private UUID uuid;
    // TODO: refactor to avoid telescoping anti pattern (extract time values)
    public FlightResource(AirportResource from, AirportResource to, LocalDateTime departureTime,
                          LocalDateTime arrivalTime, String flightNumber, AirplaneResource airplane,
                          AirlineResource operator, UUID uuid) {
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.operator = operator;
        this.uuid = uuid;
    }

    public FlightResource() {
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

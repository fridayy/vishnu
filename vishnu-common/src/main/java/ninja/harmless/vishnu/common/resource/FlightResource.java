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

    private String departureTime;
    private String arrivalTime;
    private String flightNumber;
    private String status;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AirplaneResource airplane;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private AirlineResource operator;

    private UUID uuid;

    // TODO: refactor to avoid telescoping anti pattern (extract time values)
    public FlightResource(AirportResource from, AirportResource to, LocalDateTime departureTime,
                          LocalDateTime arrivalTime, String flightNumber, AirplaneResource airplane,
                          AirlineResource operator, UUID uuid, String status) {
        this.from = from;
        this.to = to;
        this.departureTime = departureTime.toString();
        this.arrivalTime = arrivalTime.toString();
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.operator = operator;
        this.uuid = uuid;
        this.status = status;
    }

    public FlightResource() {
    }

    public AirportResource getFrom() {
        return from;
    }

    public AirportResource getTo() {
        return to;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
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

    public String getStatus() {
        return status;
    }
}

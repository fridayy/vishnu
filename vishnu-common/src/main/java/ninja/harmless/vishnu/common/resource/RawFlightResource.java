package ninja.harmless.vishnu.common.resource;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * A Raw representation of {@link FlightResource} without any Jackson annotations. This model is used as a DTO
 * between services.
 *
 * @author bnjm@harmless.ninja - 7/31/17.
 */
public class RawFlightResource {
    private AirportResource from;
    private AirportResource to;

    private String departureTime;
    private String arrivalTime;
    private String flightNumber;
    private String status;
    private AirplaneResource airplane;
    private AirlineResource operator;
    private UUID uuid;

    // TODO: refactor to avoid telescoping anti pattern (extract time values)
    public RawFlightResource(AirportResource from, AirportResource to, LocalDateTime departureTime,
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

    public RawFlightResource() {
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

package ninja.harmless.vishnu.flight.model.entity;

import ninja.harmless.vishnu.airline.model.entity.Airline;
import ninja.harmless.vishnu.airplane.model.entity.Airplane;
import ninja.harmless.vishnu.airport.model.entity.Airport;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Entity
public class Flight extends AbstractPersistable<Long> {
    @ManyToOne
    private Airport from;

    @ManyToOne
    private Airport to;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightNumber;
    private String status;

    @ManyToOne
    private Airplane airplane;

    @ManyToOne
    private Airline operator;

    private UUID uuid = UUID.randomUUID();

    public Flight() {
    }

    private Flight(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.departureTime = builder.departureTime;
        this.arrivalTime = builder.arrivalTime;
        this.flightNumber = builder.flightNumber;
        this.airplane = builder.airplane;
        this.operator = builder.operator;
        this.status = builder.status.getStringValue();
    }

    public static Builder builder() {
        return new Builder();
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
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

    public Airplane getAirplane() {
        return airplane;
    }

    public Airline getOperator() {
        return operator;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }


    public static class Builder {
        private Airport from;
        private Airport to;
        private LocalDateTime departureTime;
        private LocalDateTime arrivalTime;
        private String flightNumber;
        private Airplane airplane;
        private Airline operator;
        private FlightStatus status;

        Builder() {
            // package private default constructor for the builder
        }

        public Builder from(Airport airport) {
            this.from = airport;
            return this;
        }

        public Builder to(Airport airport) {
            this.to = airport;
            return this;
        }

        public Builder departureTime(LocalDateTime dateTime) {
            this.departureTime = dateTime;
            return this;
        }

        public Builder arrivalTime(LocalDateTime localDateTime) {
            this.arrivalTime = localDateTime;
            return this;
        }

        public Builder flightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Builder airplane(Airplane airplane) {
            this.airplane = airplane;
            return this;
        }

        public Builder operator(Airline operator) {
            this.operator = operator;
            return this;
        }

        public Builder status(FlightStatus status) {
            this.status = status;
            return this;
        }

        public Flight build() {
            return new Flight(this);
        }
    }
}

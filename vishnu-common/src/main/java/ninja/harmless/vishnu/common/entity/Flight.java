package ninja.harmless.vishnu.common.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Entity
public class Flight extends AbstractPersistable<Long> {
    @OneToOne(cascade = CascadeType.ALL)
    private Destination from;

    @OneToOne(cascade = CascadeType.ALL)
    private Destination to;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Airplane airplane;

    @OneToOne(cascade = CascadeType.ALL)
    private Airline operator;

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
    }

    public Destination getFrom() {
        return from;
    }

    public Destination getTo() {
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

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private Destination from;
        private Destination to;
        private LocalDateTime departureTime;
        private LocalDateTime arrivalTime;
        private String flightNumber;
        private Airplane airplane;
        private Airline operator;

        public Builder() {
        }

        public Builder from(Destination destination) {
            this.from = destination;
            return this;
        }

        public Builder to(Destination destination) {
            this.to = destination;
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

        public Flight build() {
            return new Flight(this);
        }
    }
}

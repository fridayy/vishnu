package ninja.harmless.vishnu.airport.model.entity;

import ninja.harmless.vishnu.country.model.entity.Country;
import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

/**
 * Represents an Airport Airport
 *
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Entity
public class Airport extends AbstractPersistable<Long> {
    private String iataCode;
    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;
    private String city;

    private UUID uuid = UUID.randomUUID();

    @OneToMany
    private List<Flight> flightList;

    public Airport(String iataCode, Country country, String city) {
        this.iataCode = iataCode;
        this.country = country;
        this.city = city;
    }

    public Airport() {
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
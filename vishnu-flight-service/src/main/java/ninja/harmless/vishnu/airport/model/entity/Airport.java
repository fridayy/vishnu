package ninja.harmless.vishnu.airport.model.entity;

import ninja.harmless.vishnu.country.model.entity.Country;
import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

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
    @ManyToOne
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(iataCode, airport.iataCode)
                .append(country, airport.country)
                .append(city, airport.city)
                .append(uuid, airport.uuid)
                .append(flightList, airport.flightList)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(iataCode)
                .append(country)
                .append(city)
                .append(uuid)
                .append(flightList)
                .toHashCode();
    }
}

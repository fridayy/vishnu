package ninja.harmless.vishnu.common.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

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
}
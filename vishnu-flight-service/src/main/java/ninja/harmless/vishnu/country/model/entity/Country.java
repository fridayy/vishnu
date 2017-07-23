package ninja.harmless.vishnu.country.model.entity;

import ninja.harmless.vishnu.airport.model.entity.Airport;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Entity
public class Country extends AbstractPersistable<Long> {
    private String countryCode;
    private String name;
    private UUID uuid = UUID.randomUUID();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Airport> airportList;


    public Country(String countryCode, String name) {
        this.countryCode = countryCode;
        this.name = name;
    }

    public Country() {
    }


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airport> getAirportList() {
        return airportList;
    }

    public void setAirportList(List<Airport> airportList) {
        this.airportList = airportList;
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

        Country country = (Country) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(countryCode, country.countryCode)
                .append(name, country.name)
                .append(uuid, country.uuid)
                .append(airportList, country.airportList)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(countryCode)
                .append(name)
                .append(uuid)
                .append(airportList)
                .toHashCode();
    }
}

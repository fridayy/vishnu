package ninja.harmless.vishnu.common.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class AirportResource extends ResourceSupport {
    private final String iataCode;
    private final CountryResource country;
    private final String city;
    private final UUID uuid;

    public AirportResource(String iataCode, CountryResource country, String city, UUID uuid) {
        this.iataCode = iataCode;
        this.country = country;
        this.city = city;
        this.uuid = uuid;
    }

    public String getIataCode() {
        return iataCode;
    }

    public CountryResource getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public UUID getUuid() {
        return uuid;
    }
}

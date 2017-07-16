package ninja.harmless.vishnu.common.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class AirportResource extends ResourceSupport {
    private final String iataCode;
    private final String city;
    private final UUID uuid;
    @JsonIgnore
    private final CountryResource countryResource;

    public AirportResource(String iataCode, String city, UUID uuid, CountryResource countryResource) {
        this.iataCode = iataCode;
        this.city = city;
        this.uuid = uuid;
        this.countryResource = countryResource;
    }

    public String getIataCode() {
        return iataCode;
    }

    public String getCity() {
        return city;
    }

    public UUID getUuid() {
        return uuid;
    }
}

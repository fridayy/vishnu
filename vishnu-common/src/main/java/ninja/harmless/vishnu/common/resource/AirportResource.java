package ninja.harmless.vishnu.common.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class AirportResource extends ResourceSupport {
    private String iataCode;
    private String city;
    private UUID uuid;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CountryResource countryResource;

    public AirportResource(String iataCode, String city, UUID uuid, CountryResource countryResource) {
        this.iataCode = iataCode;
        this.city = city;
        this.uuid = uuid;
        this.countryResource = countryResource;
    }

    public AirportResource() {
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

    public CountryResource getCountryResource() {
        return countryResource;
    }
}

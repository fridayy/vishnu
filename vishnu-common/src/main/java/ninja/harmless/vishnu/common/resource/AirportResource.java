package ninja.harmless.vishnu.common.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AirportResource that = (AirportResource) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(iataCode, that.iataCode)
                .append(city, that.city)
                .append(uuid, that.uuid)
                .append(countryResource, that.countryResource)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(iataCode)
                .append(city)
                .append(uuid)
                .append(countryResource)
                .toHashCode();
    }
}

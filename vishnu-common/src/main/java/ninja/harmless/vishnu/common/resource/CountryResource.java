package ninja.harmless.vishnu.common.resource;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class CountryResource extends ResourceSupport {
    private String countryCode;
    private String name;
    private UUID uuid;

    public CountryResource(String countryCode, String name, UUID uuid) {
        this.countryCode = countryCode;
        this.name = name;
        this.uuid = uuid;
    }

    public CountryResource() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CountryResource that = (CountryResource) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(countryCode, that.countryCode)
                .append(name, that.name)
                .append(uuid, that.uuid)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(countryCode)
                .append(name)
                .append(uuid)
                .toHashCode();
    }
}

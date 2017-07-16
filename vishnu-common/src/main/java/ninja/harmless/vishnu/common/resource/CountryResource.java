package ninja.harmless.vishnu.common.resource;

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
}

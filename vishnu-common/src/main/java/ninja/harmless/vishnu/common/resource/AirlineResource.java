package ninja.harmless.vishnu.common.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

/**
 * A REST Resource representation of an Airline
 *
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class AirlineResource extends ResourceSupport {
    private UUID uuid;
    private String name;

    public AirlineResource(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

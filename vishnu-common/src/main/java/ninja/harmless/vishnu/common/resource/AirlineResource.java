package ninja.harmless.vishnu.common.resource;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    public AirlineResource() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AirlineResource that = (AirlineResource) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(uuid, that.uuid)
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(uuid)
                .append(name)
                .toHashCode();
    }
}

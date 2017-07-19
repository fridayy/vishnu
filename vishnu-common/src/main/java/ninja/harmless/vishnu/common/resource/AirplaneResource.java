package ninja.harmless.vishnu.common.resource;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class AirplaneResource extends ResourceSupport {
    private String typeDeclaration;
    private Integer capacity;
    private UUID uuid;

    public AirplaneResource(String typeDeclaration, Integer capacity, UUID uuid) {
        this.typeDeclaration = typeDeclaration;
        this.capacity = capacity;
        this.uuid = uuid;
    }

    public AirplaneResource() {
    }

    public String getTypeDeclaration() {
        return typeDeclaration;
    }

    public void setTypeDeclaration(String typeDeclaration) {
        this.typeDeclaration = typeDeclaration;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

        AirplaneResource that = (AirplaneResource) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(typeDeclaration, that.typeDeclaration)
                .append(capacity, that.capacity)
                .append(uuid, that.uuid)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(typeDeclaration)
                .append(capacity)
                .append(uuid)
                .toHashCode();
    }
}

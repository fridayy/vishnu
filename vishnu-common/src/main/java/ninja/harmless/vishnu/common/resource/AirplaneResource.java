package ninja.harmless.vishnu.common.resource;

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
}

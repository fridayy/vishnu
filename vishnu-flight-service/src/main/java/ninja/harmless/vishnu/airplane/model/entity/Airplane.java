package ninja.harmless.vishnu.airplane.model.entity;

import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Entity
public class Airplane extends AbstractPersistable<Long> {
    private String typeDeclaration;
    private Integer capacity;

    private UUID uuid = UUID.randomUUID();

    @OneToMany
    private List<Flight> flights;

    public Airplane(String typeDeclaration, Integer capacity) {
        this.typeDeclaration = typeDeclaration;
        this.capacity = capacity;
    }

    public Airplane() {
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

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}

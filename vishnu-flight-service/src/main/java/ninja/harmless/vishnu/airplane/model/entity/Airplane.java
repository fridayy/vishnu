package ninja.harmless.vishnu.airplane.model.entity;

import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
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

    @OneToMany(cascade = CascadeType.ALL)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Airplane airplane = (Airplane) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(typeDeclaration, airplane.typeDeclaration)
                .append(capacity, airplane.capacity)
                .append(uuid, airplane.uuid)
                .append(flights, airplane.flights)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(typeDeclaration)
                .append(capacity)
                .append(uuid)
                .append(flights)
                .toHashCode();
    }
}

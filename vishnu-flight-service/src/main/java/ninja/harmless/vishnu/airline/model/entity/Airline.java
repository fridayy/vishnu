package ninja.harmless.vishnu.airline.model.entity;

import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Entity
public class Airline extends AbstractPersistable<Long> {
    private String name;
    private UUID uuid = UUID.randomUUID();

    @OneToMany
    private List<Flight> flightList;

    public Airline(String name) {
        this.name = name;
    }

    public Airline() {
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Airline airline = (Airline) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, airline.name)
                .append(uuid, airline.uuid)
                .append(flightList, airline.flightList)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(name)
                .append(uuid)
                .append(flightList)
                .toHashCode();
    }
}

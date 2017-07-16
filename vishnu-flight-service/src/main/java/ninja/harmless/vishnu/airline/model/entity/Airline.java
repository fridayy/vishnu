package ninja.harmless.vishnu.airline.model.entity;

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
}

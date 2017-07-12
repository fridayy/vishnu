package ninja.harmless.vishnu.common.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Entity
public class Airline extends AbstractPersistable<Long> {
    private String name;

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

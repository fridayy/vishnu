package ninja.harmless.vishnu.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Represents an Airport Destination
 *
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Entity
@Data
@AllArgsConstructor
public class Destination extends AbstractPersistable<Long> {
    private String iataCode;
    @OneToOne(cascade = CascadeType.ALL)
    private Country country;
    private String city;

    public Destination() {
    }
}

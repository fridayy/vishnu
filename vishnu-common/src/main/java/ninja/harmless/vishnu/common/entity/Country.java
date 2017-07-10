package ninja.harmless.vishnu.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Entity
@Data
@AllArgsConstructor
public class Country extends AbstractPersistable<Long> {
    private String countryCode;
    private String name;

    public Country() {
    }
}

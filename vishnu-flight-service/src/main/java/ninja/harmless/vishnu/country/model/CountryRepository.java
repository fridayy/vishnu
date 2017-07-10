package ninja.harmless.vishnu.country.model;

import ninja.harmless.vishnu.common.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
}

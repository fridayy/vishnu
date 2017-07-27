package ninja.harmless.vishnu.country.model;

import ninja.harmless.vishnu.airport.model.entity.Airport;
import ninja.harmless.vishnu.country.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findCountryByCountryCode(String countryCode);

    Country findByAirportListContains(Airport airport);

    Optional<Country> findByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

}

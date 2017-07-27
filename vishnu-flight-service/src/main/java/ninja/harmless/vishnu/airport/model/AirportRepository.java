package ninja.harmless.vishnu.airport.model;

import ninja.harmless.vishnu.airport.model.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/12/17.
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findAirportByIataCode(String iataCode);

    List<Airport> findAirportsByCity(String city);

    Optional<Airport> findAirportsByUuid(UUID uuid);

    void deleteAirportByUuid(UUID uuid);
}

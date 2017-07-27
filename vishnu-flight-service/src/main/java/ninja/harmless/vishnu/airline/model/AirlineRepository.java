package ninja.harmless.vishnu.airline.model;

import ninja.harmless.vishnu.airline.model.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/12/17.
 */
@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Optional<Airline> findAirlineByName(String name);

    Optional<Airline> findAirlineByUuid(UUID uuid);

    void deleteAirlineByUuid(UUID uuid);
}

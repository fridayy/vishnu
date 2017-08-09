package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findByUuid(UUID uuid);

    Optional<Flight> findFlightByFlightNumber(String flightNumber);
}

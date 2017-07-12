package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.common.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bnjm@harmless.ninja - 7/12/17.
 */
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Airline findAirlineByName(String name);
}

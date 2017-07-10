package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.common.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
public interface FlightRepository extends JpaRepository<Flight, Long>{
}

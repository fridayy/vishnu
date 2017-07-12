package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.common.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author bnjm@harmless.ninja - 7/12/17.
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findAirportByIataCode(String iataCode);

    List<Airport> findAirportsByCity(String city);
}

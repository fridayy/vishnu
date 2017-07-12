package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.common.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bnjm@harmless.ninja - 7/12/17.
 */
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    Airplane findAirplaneByTypeDeclaration(String typeDeclaration);
}

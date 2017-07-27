package ninja.harmless.vishnu.airplane.model;

import ninja.harmless.vishnu.airplane.model.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/12/17.
 */
@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    Optional<Airplane> findAirplaneByTypeDeclaration(String typeDeclaration);

    Optional<Airplane> findAirplaneByUuid(UUID uuid);

    void deleteAirplaneByUuid(UUID uuid);
}

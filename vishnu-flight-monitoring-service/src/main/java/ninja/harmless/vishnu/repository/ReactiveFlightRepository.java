package ninja.harmless.vishnu.repository;

import ninja.harmless.vishnu.common.resource.RawFlightResource;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/31/17.
 */
@Repository
public interface ReactiveFlightRepository extends ReactiveMongoRepository<RawFlightResource, UUID> {
    @Tailable
    Flux<RawFlightResource> findBy();
}

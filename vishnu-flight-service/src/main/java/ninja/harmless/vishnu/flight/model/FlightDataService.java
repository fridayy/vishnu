package ninja.harmless.vishnu.flight.model;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import ninja.harmless.vishnu.common.data.GenericDataService;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassembler;
import ninja.harmless.vishnu.common.resource.FlightResource;
import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Service
public class FlightDataService extends GenericDataService<Flight, FlightResource> {

    public FlightDataService(FlightRepository repository, ResourceAssembler<Flight, FlightResource> resourceAssembler, ResourceDisassembler<FlightResource, Flight> resourceDisassembler) {
        super(repository, resourceAssembler, resourceDisassembler);
    }

    @Override
    public FlightResource findOneByUUID(UUID uuid) {
        Assert.notNull(uuid, "uuid cannot be null");
        FlightRepository concreteRepository = (FlightRepository) repository;
        Optional<Flight> optional = concreteRepository.findByUuid(uuid);

        return resourceAssembler.toResource(optional.orElseThrow(ResourceNotFoundException::new));

    }

    @Override
    public FlightResource delete(UUID uuid) {
        return null;
    }

    @Override
    public FlightResource update(FlightResource entity) {
        FlightRepository concreteRepository = (FlightRepository) repository;
        Flight f = resourceDisassembler.fromResource(entity);
        concreteRepository.save(f);
        return entity;
    }

    @Override
    @HystrixCommand
    public FlightResource insert(FlightResource entity) {
        this.repository.save(resourceDisassembler.fromResource(entity));

        return entity;
    }
}

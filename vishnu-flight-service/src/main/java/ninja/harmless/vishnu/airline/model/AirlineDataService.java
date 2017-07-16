package ninja.harmless.vishnu.airline.model;

import ninja.harmless.vishnu.airline.model.entity.Airline;
import ninja.harmless.vishnu.common.data.GenericDataService;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassmbler;
import ninja.harmless.vishnu.common.resource.AirlineResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Service
public class AirlineDataService extends GenericDataService<Airline, AirlineResource> {

    @Autowired
    public AirlineDataService(AirlineRepository repository, ResourceAssembler<Airline, AirlineResource> resourceAssembler, ResourceDisassmbler<AirlineResource, Airline> resourceDisassmbler) {
        super(repository, resourceAssembler, resourceDisassmbler);
    }

    @Override
    public AirlineResource findOneByUUID(UUID uuid) {
        AirlineRepository a = (AirlineRepository) repository;
        Optional<Airline> entity = a.findAirlineByUuid(uuid);
        return entity.map(resourceAssembler::toResource).orElseThrow(ResourceNotFoundException::new);
    }


    @Override
    public AirlineResource delete(UUID uuid) {
        AirlineRepository a = (AirlineRepository) repository;
        Optional<Airline> airline = a.findAirlineByUuid(uuid);
        a.deleteAirlineByUuid(airline.orElseThrow(ResourceNotFoundException::new).getUuid());

        return resourceAssembler.toResource(airline.orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public AirlineResource update(AirlineResource entity) {
        AirlineRepository a = (AirlineRepository) repository;
        Airline airline = resourceDisassmbler.fromResource(entity);
        Optional<Airline> optional = a.findAirlineByUuid(airline.getUuid());
        optional.orElseThrow(ResourceNotFoundException::new);
        repository.save(airline);

        return entity;
    }
}

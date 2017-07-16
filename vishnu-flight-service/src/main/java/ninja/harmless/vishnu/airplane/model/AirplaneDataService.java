package ninja.harmless.vishnu.airplane.model;

import ninja.harmless.vishnu.airplane.model.entity.Airplane;
import ninja.harmless.vishnu.common.data.GenericDataService;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassmbler;
import ninja.harmless.vishnu.common.resource.AirplaneResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Service
public class AirplaneDataService extends GenericDataService<Airplane, AirplaneResource> {

    @Autowired
    public AirplaneDataService(AirplaneRepository repository, ResourceAssembler<Airplane, AirplaneResource> resourceAssembler, ResourceDisassmbler<AirplaneResource, Airplane> resourceDisassmbler) {
        super(repository, resourceAssembler, resourceDisassmbler);
    }

    @Override
    public AirplaneResource findOneByUUID(UUID uuid) {
        AirplaneRepository concreteRepository = (AirplaneRepository) repository;
        Optional<Airplane> entity = concreteRepository.findAirplaneByUuid(uuid);

        return entity.map(resourceAssembler::toResource).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public AirplaneResource delete(UUID uuid) {
        AirplaneRepository concreteRepository = (AirplaneRepository) repository;
        Optional<Airplane> airplane = concreteRepository.findAirplaneByUuid(uuid);
        concreteRepository.deleteAirplaneByUuid(airplane.orElseThrow(ResourceNotFoundException::new).getUuid());

        return resourceAssembler.toResource(airplane.orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public AirplaneResource update(AirplaneResource entity) {
        AirplaneRepository concreteRepository = (AirplaneRepository) repository;
        Airplane airplane = resourceDisassmbler.fromResource(entity);
        Optional<Airplane> optional = concreteRepository.findAirplaneByUuid(airplane.getUuid());
        optional.orElseThrow(ResourceNotFoundException::new);
        repository.save(airplane);

        return entity;
    }
}

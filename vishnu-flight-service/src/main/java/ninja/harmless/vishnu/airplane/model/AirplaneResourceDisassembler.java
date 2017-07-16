package ninja.harmless.vishnu.airplane.model;

import ninja.harmless.vishnu.airplane.model.entity.Airplane;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassmbler;
import ninja.harmless.vishnu.common.resource.AirplaneResource;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class AirplaneResourceDisassembler implements ResourceDisassmbler<AirplaneResource, Airplane> {
    @Override
    public Airplane fromResource(AirplaneResource resource) {
        Optional<AirplaneResource> optional = Optional.ofNullable(resource);
        if(optional.isPresent()) {
            return new Airplane(resource.getTypeDeclaration(), resource.getCapacity());
        }
        throw new ResourceNotFoundException();
    }
}

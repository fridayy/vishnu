package ninja.harmless.vishnu.airplane.model;

import ninja.harmless.vishnu.airplane.controller.AirplaneController;
import ninja.harmless.vishnu.airplane.model.entity.Airplane;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.resource.AirplaneResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class AirplaneResourceAssembler extends ResourceAssemblerSupport<Airplane, AirplaneResource> {

    /**
     * Creates a new {@link ResourceAssemblerSupport} using the given controller class and resource type.
     */
    public AirplaneResourceAssembler() {
        super(AirplaneController.class, AirplaneResource.class);
    }

    @Override
    public AirplaneResource toResource(Airplane entity) {
        Optional<Airplane> optional = Optional.ofNullable(entity);
        if(optional.isPresent()) {
            return new AirplaneResource(entity.getTypeDeclaration(), entity.getCapacity(), entity.getUuid());
        }
        throw new ResourceNotFoundException();
    }
}

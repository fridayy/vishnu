package ninja.harmless.vishnu.airline.model;

import ninja.harmless.vishnu.airline.controller.AirlineController;
import ninja.harmless.vishnu.airline.model.entity.Airline;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.resource.AirlineResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class AirlineResourceAssembler extends ResourceAssemblerSupport<Airline, AirlineResource> {
    /**
     * Creates a new {@link ResourceAssemblerSupport}.
     */
    public AirlineResourceAssembler() {
        super(AirlineController.class, AirlineResource.class);
    }

    @Override
    public AirlineResource toResource(Airline entity) {
        Optional<Airline> airline = Optional.ofNullable(entity);
        airline.orElseThrow(ResourceNotFoundException::new);
        AirlineResource resource = new AirlineResource(null, null);
        airline.ifPresent(item -> {
            resource.setName(item.getName());
            resource.setUuid(item.getUuid());
        });
        return resource;
    }
}

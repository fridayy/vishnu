package ninja.harmless.vishnu.airline.model;

import ninja.harmless.vishnu.airline.model.entity.Airline;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassmbler;
import ninja.harmless.vishnu.common.resource.AirlineResource;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class AirlineResourceDisassembler implements ResourceDisassmbler<AirlineResource, Airline> {
    @Override
    public Airline fromResource(AirlineResource resource) {
        Optional<AirlineResource> optional = Optional.ofNullable(resource);
        return new Airline(optional.orElseThrow(ResourceNotFoundException::new).getName());
    }
}

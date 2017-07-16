package ninja.harmless.vishnu.airport.model;

import ninja.harmless.vishnu.airport.model.entity.Airport;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassmbler;
import ninja.harmless.vishnu.common.resource.AirportResource;
import org.springframework.stereotype.Component;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class AirportResourceDisassembler implements ResourceDisassmbler<AirportResource, Airport> {
    @Override
    public Airport fromResource(AirportResource resource) {
        return null;
    }
}

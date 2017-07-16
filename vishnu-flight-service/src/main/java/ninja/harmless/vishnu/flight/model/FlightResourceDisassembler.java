package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.common.hateoas.ResourceDisassembler;
import ninja.harmless.vishnu.common.resource.FlightResource;
import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.springframework.stereotype.Component;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class FlightResourceDisassembler implements ResourceDisassembler<FlightResource, Flight> {
    @Override
    public Flight fromResource(FlightResource resource) {
        return null;
    }
}

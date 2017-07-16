package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.common.data.GenericDataService;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassembler;
import ninja.harmless.vishnu.common.resource.FlightResource;
import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public FlightResource delete(UUID uuid) {
        return null;
    }

    @Override
    public FlightResource update(FlightResource entity) {
        return null;
    }
}

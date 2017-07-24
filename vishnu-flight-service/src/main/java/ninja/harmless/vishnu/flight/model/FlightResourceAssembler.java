package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.airline.controller.AirlineController;
import ninja.harmless.vishnu.airline.model.AirlineResourceAssembler;
import ninja.harmless.vishnu.airplane.controller.AirplaneController;
import ninja.harmless.vishnu.airplane.model.AirplaneResourceAssembler;
import ninja.harmless.vishnu.airport.controller.AirportController;
import ninja.harmless.vishnu.airport.model.AirportResourceAssembler;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.resource.FlightResource;
import ninja.harmless.vishnu.flight.controller.FlightController;
import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static ninja.harmless.vishnu.common.hateoas.LinkBuilderAdapter.linkTo;
import static ninja.harmless.vishnu.common.hateoas.LinkBuilderAdapter.methodOn;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class FlightResourceAssembler extends ResourceAssemblerSupport<Flight, FlightResource> {


    @Autowired
    private AirportResourceAssembler airportResourceAssembler;

    @Autowired
    private AirplaneResourceAssembler airplaneResourceAssembler;

    @Autowired
    private AirlineResourceAssembler airlineResourceAssembler;

    /**
     * Creates a new {@link ResourceAssemblerSupport} using the given controller class and resource type.
     */
    public FlightResourceAssembler() {
        super(FlightController.class, FlightResource.class);
    }

    @Override
    public FlightResource toResource(Flight entity) {
        Optional<Flight> optional = Optional.ofNullable(entity);
        if (optional.isPresent()) {
            FlightResource resource = new FlightResource(airportResourceAssembler.toResource(entity.getFrom()),
                    airportResourceAssembler.toResource(entity.getTo()),
                    entity.getDepartureTime(),
                    entity.getArrivalTime(),
                    entity.getFlightNumber(),
                    airplaneResourceAssembler.toResource(entity.getAirplane()),
                    airlineResourceAssembler.toResource(entity.getOperator()),
                    entity.getUuid(),
                    entity.getStatus());

            resource.add(linkTo(methodOn(AirportController.class).getOne(entity.getFrom().getUuid().toString())).withRel("from"));
            resource.add(linkTo(methodOn(AirportController.class).getOne(entity.getTo().getUuid().toString())).withRel("to"));
            resource.add(linkTo(methodOn(AirplaneController.class).getOne(entity.getAirplane().getUuid().toString())).withRel("airplane"));
            resource.add(linkTo(methodOn(AirlineController.class).getOne(entity.getOperator().getUuid().toString())).withRel("airline"));

            return resource;
        }

        throw new ResourceNotFoundException();
    }
}

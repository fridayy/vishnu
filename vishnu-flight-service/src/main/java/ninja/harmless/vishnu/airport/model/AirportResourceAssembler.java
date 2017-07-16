package ninja.harmless.vishnu.airport.model;

import ninja.harmless.vishnu.airport.controller.AirportController;
import ninja.harmless.vishnu.airport.model.entity.Airport;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.LinkBuilderAdapter;
import ninja.harmless.vishnu.common.resource.AirportResource;
import ninja.harmless.vishnu.country.controller.CountryController;
import ninja.harmless.vishnu.country.model.CountryResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class AirportResourceAssembler extends ResourceAssemblerSupport<Airport, AirportResource> {

    @Autowired
    private CountryResourceAssembler countryResourceAssembler;

    /**
     * Creates a new {@link ResourceAssemblerSupport} using the given controller class and resource type.
     */
    public AirportResourceAssembler() {
        super(AirportController.class, AirportResource.class);
    }

    @Override
    public AirportResource toResource(Airport entity) {
        Optional<Airport> optional = Optional.ofNullable(entity);
        if (optional.isPresent()) {
            AirportResource r = new AirportResource(entity.getIataCode(), entity.getCity(), entity.getUuid(), countryResourceAssembler.toResource(entity.getCountry()));
            // Add the relational link to country resource
            r.add(LinkBuilderAdapter.linkTo(LinkBuilderAdapter.methodOn(CountryController.class).getOne(entity.getCountry().getUuid().toString())).withRel("country"));

            return r;
        }

        throw new ResourceNotFoundException();
    }
}

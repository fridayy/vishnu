package ninja.harmless.vishnu.airport.model;

import ninja.harmless.vishnu.airport.controller.AirportContoller;
import ninja.harmless.vishnu.airport.model.entity.Airport;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.resource.AirportResource;
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
        super(AirportContoller.class, AirportResource.class);
    }

    @Override
    public AirportResource toResource(Airport entity) {
        Optional<Airport> optional = Optional.ofNullable(entity);
        if (optional.isPresent()) {
            return new AirportResource(entity.getIataCode(), countryResourceAssembler.toResource(entity.getCountry()), entity.getCity(), entity.getUuid());
        }

        throw new ResourceNotFoundException();
    }
}

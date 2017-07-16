package ninja.harmless.vishnu.airport.model;

import ninja.harmless.vishnu.airport.model.entity.Airport;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassembler;
import ninja.harmless.vishnu.common.resource.AirportResource;
import ninja.harmless.vishnu.country.model.CountryResourceDisassembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class AirportResourceDisassembler implements ResourceDisassembler<AirportResource, Airport> {

    @Autowired
    private CountryResourceDisassembler countryResourceDisassembler;

    @Override
    public Airport fromResource(AirportResource resource) {
        Optional<AirportResource> optional = Optional.ofNullable(resource);
        if (optional.isPresent()) {
            return new Airport(resource.getIataCode(),
                    countryResourceDisassembler.fromResource(resource.getCountryResource()),
                    resource.getCity());
        }
        throw new ResourceNotFoundException();
    }
}

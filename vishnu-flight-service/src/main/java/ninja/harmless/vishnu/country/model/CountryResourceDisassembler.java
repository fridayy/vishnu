package ninja.harmless.vishnu.country.model;

import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassmbler;
import ninja.harmless.vishnu.common.resource.CountryResource;
import ninja.harmless.vishnu.country.model.entity.Country;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class CountryResourceDisassembler implements ResourceDisassmbler<CountryResource, Country> {

    @Override
    public Country fromResource(CountryResource resource) {
        Optional<CountryResource> optional = Optional.ofNullable(resource);

        if (optional.isPresent()) {
            return new Country(resource.getCountryCode(), resource.getName());
        }

        throw new ResourceNotFoundException();
    }
}

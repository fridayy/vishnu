package ninja.harmless.vishnu.country.model;

import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.resource.CountryResource;
import ninja.harmless.vishnu.country.controller.CountryController;
import ninja.harmless.vishnu.country.model.entity.Country;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
public class CountryResourceAssembler extends ResourceAssemblerSupport<Country, CountryResource> {
    /**
     * Creates a new {@link ResourceAssemblerSupport} using the given controller class and resource type.
     */
    public CountryResourceAssembler() {
        super(CountryController.class, CountryResource.class);
    }

    @Override
    public CountryResource toResource(Country entity) {
        Optional<Country> optional = Optional.ofNullable(entity);

        if (optional.isPresent()) {
            return new CountryResource(entity.getCountryCode(), entity.getName(), entity.getUuid());
        }

        throw new ResourceNotFoundException();
    }
}

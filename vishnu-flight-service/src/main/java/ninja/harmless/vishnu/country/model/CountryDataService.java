package ninja.harmless.vishnu.country.model;

import ninja.harmless.vishnu.common.data.GenericDataService;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassembler;
import ninja.harmless.vishnu.common.resource.CountryResource;
import ninja.harmless.vishnu.country.model.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Service
public class CountryDataService extends GenericDataService<Country, CountryResource> {

    @Autowired
    public CountryDataService(CountryRepository repository, ResourceAssembler<Country, CountryResource> resourceAssembler, ResourceDisassembler<CountryResource, Country> resourceDisassembler) {
        super(repository, resourceAssembler, resourceDisassembler);
    }

    @Override
    public CountryResource findOneByUUID(UUID uuid) {
        CountryRepository concreteRepository = (CountryRepository) repository;
        Optional<Country> entity = concreteRepository.findByUuid(uuid);

        return entity.map(resourceAssembler::toResource).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CountryResource delete(UUID uuid) {
        CountryRepository concreteRepository = (CountryRepository) repository;
        Optional<Country> airplane = concreteRepository.findByUuid(uuid);
        concreteRepository.deleteByUuid(airplane.orElseThrow(ResourceNotFoundException::new).getUuid());

        return resourceAssembler.toResource(airplane.orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public CountryResource update(CountryResource entity) {
        CountryRepository concreteRepository = (CountryRepository) repository;
        Country country = resourceDisassembler.fromResource(entity);
        Optional<Country> optional = concreteRepository.findByUuid(country.getUuid());
        optional.orElseThrow(ResourceNotFoundException::new);
        repository.save(country);

        return entity;
    }

    public CountryResource findByCountryCode(String countryCode) {
        Assert.notNull(countryCode, "Country code cannot be null");
        CountryRepository concreteRepository = (CountryRepository) repository;
        Optional<Country> country = Optional.ofNullable(concreteRepository.findCountryByCountryCode(countryCode));
        return resourceAssembler.toResource(country.orElseThrow(ResourceNotFoundException::new));
    }
}

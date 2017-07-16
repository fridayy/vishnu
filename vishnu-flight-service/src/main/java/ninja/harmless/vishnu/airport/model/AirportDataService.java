package ninja.harmless.vishnu.airport.model;

import ninja.harmless.vishnu.airport.model.entity.Airport;
import ninja.harmless.vishnu.common.data.GenericDataService;
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassembler;
import ninja.harmless.vishnu.common.resource.AirportResource;
import ninja.harmless.vishnu.country.model.CountryRepository;
import ninja.harmless.vishnu.country.model.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Service
public class AirportDataService extends GenericDataService<Airport, AirportResource>{

    private CountryRepository countryRepository;

    @Autowired
    public AirportDataService(AirportRepository repository, ResourceAssembler<Airport, AirportResource> resourceAssembler,
                              ResourceDisassembler<AirportResource, Airport> resourceDisassembler,
                              CountryRepository countryRepository) {
        super(repository, resourceAssembler, resourceDisassembler);
        this.countryRepository = countryRepository;
    }

    @Override
    public AirportResource findOneByUUID(UUID uuid) {
        AirportRepository concreteRepository = (AirportRepository) repository;
        Optional<Airport> entity = concreteRepository.findAirportsByUuid(uuid);

        return entity.map(resourceAssembler::toResource).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public AirportResource delete(UUID uuid) {
        AirportRepository concreteRepository = (AirportRepository) repository;
        Optional<Airport> airplane = concreteRepository.findAirportsByUuid(uuid);
        concreteRepository.deleteAirportByUuid(airplane.orElseThrow(ResourceNotFoundException::new).getUuid());

        return resourceAssembler.toResource(airplane.orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public AirportResource update(AirportResource entity) {
        AirportRepository concreteRepository = (AirportRepository) repository;
        Airport airport = resourceDisassembler.fromResource(entity);
        Optional<Airport> optional = concreteRepository.findAirportsByUuid(airport.getUuid());
        optional.orElseThrow(ResourceNotFoundException::new);
        repository.save(airport);

        return entity;
    }

    @Override
    public List<AirportResource> findAll() {
        List<Airport> items = (List<Airport>) repository.findAll();
        return items.stream()
                .filter(airport -> airport.getCountry() != null)
                .map(resourceAssembler::toResource).collect(Collectors.toList());
    }

    @Override
    public AirportResource insert(AirportResource entity) {
        if (entity.getCountryResource() != null) {
            Country country = countryRepository.findCountryByCountryCode(entity.getCountryResource().getCountryCode());
            if (country == null) {
                return super.insert(entity);
            }
            Airport airport = resourceDisassembler.fromResource(entity);
            airport.setCountry(country);
            repository.save(airport);

            return entity;
        }
        return super.insert(entity);
    }
}

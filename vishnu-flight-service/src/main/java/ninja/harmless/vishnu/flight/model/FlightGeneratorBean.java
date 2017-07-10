package ninja.harmless.vishnu.flight.model;

import ninja.harmless.vishnu.common.entity.Country;
import ninja.harmless.vishnu.common.external.GenericPropertiesReader;
import ninja.harmless.vishnu.country.model.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Generates a couple of flights after this component has been constructed by spring
 *
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Component
public class FlightGeneratorBean {

    @Autowired
    private CountryRepository countryRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<Country> readCountries() {
        GenericPropertiesReader r = new GenericPropertiesReader();
        return r.read("countries.properties", Country.class);
    }


    @PostConstruct
    private void persist() {
       countryRepository.saveAll(readCountries());
    }
}

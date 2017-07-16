package ninja.harmless.vishnu.common.helper;

import ninja.harmless.vishnu.airline.model.AirlineRepository;
import ninja.harmless.vishnu.airline.model.entity.Airline;
import ninja.harmless.vishnu.airplane.model.AirplaneRepository;
import ninja.harmless.vishnu.airplane.model.entity.Airplane;
import ninja.harmless.vishnu.airport.model.AirportRepository;
import ninja.harmless.vishnu.airport.model.entity.Airport;
import ninja.harmless.vishnu.common.external.GenericPropertiesReader;
import ninja.harmless.vishnu.country.model.CountryRepository;
import ninja.harmless.vishnu.country.model.entity.Country;
import ninja.harmless.vishnu.flight.model.FlightRepository;
import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Generates a couple of flights after this component has been constructed by spring
 *
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@Component
@Profile("h2db")
public class FlightGeneratorBean {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CountryRepository countryRepository;
    private AirplaneRepository airplaneRepository;
    private AirportRepository airportRepository;
    private FlightRepository flightRepository;
    private AirlineRepository airlineRepository;

    @Autowired
    public FlightGeneratorBean(CountryRepository countryRepository, AirplaneRepository airplaneRepository, AirportRepository airportRepository, FlightRepository flightRepository, AirlineRepository airlineRepository) {
        this.countryRepository = countryRepository;
        this.airplaneRepository = airplaneRepository;
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
        this.airlineRepository = airlineRepository;
    }


    private List<Country> readCountries() {
        GenericPropertiesReader r = new GenericPropertiesReader();
        return r.read("countries.properties", Country.class);
    }

    private List<Airplane> readAirplanes() {
        GenericPropertiesReader r = new GenericPropertiesReader();
        return r.read("planes.properties", Airplane.class);
    }

    private List<Airport> readAirports() {
        Resource resource = new ClassPathResource("airports.csv");
        List<Airport> airports = new ArrayList<>();
        try (Reader r = new InputStreamReader(resource.getInputStream())) {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(r);
            records.forEach(record -> {
                assert countryRepository.count() != 0;
                Country c = countryRepository.findCountryByCountryCode(record.get("iso_country"));
                Airport airport = new Airport(record.get("ident"), c, record.get("municipality"));
                airports.add(airport);
            });
        } catch (IOException e) {
            logger.error("Could not read airports.csv");
        }
        return airports;
    }

    private List<Airline> readAirlines() {
        Resource resource = new ClassPathResource("airlines.csv");
        List<Airline> airlines = new ArrayList<>();
        try (Reader r = new InputStreamReader(resource.getInputStream())){
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(r);
            records.forEach(record ->
                    airlines.add(new Airline(record.get(0))));
        } catch (IOException e) {
            logger.error("Could not read airlines.csv");
        }
        return airlines;
    }

    @PostConstruct
    @javax.transaction.Transactional
    private void persist() {
        countryRepository.saveAll(readCountries());
        airplaneRepository.saveAll(readAirplanes());
        airlineRepository.saveAll(readAirlines());
        airportRepository.saveAll(readAirports());
        Flight flight = Flight.builder()
                .airplane(airplaneRepository.findAirplaneByTypeDeclaration("Embraer-170"))
                .from(airportRepository.findAirportByIataCode("LOWG"))
                .to(airportRepository.findAirportByIataCode("LOWW"))
                .operator(airlineRepository.findAirlineByName("Lufthansa"))
                .flightNumber("LH127")
                .departureTime(LocalDateTime.now().plusHours(1))
                .arrivalTime(LocalDateTime.now().plusHours(1).plusMinutes(30L)).build();
        flightRepository.save(flight);
        logger.debug("Dataloading finished");
    }
}

package ninja.harmless.vishnu.flight.controller;

import ninja.harmless.vishnu.common.entity.*;
import ninja.harmless.vishnu.flight.model.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}")
public class FlightController {

    @Autowired
    private FlightRepository repository;

    @GetMapping("/flights")
    public List<Flight> flights() {
        return repository.findAll();
    }


    @PostConstruct
    private void populate() {

        Country austria = new Country("AT", "Austria");
        Airline aua = new Airline("Austrian Airlines");

        Flight f = Flight.builder()
                .airplane(new Airplane("Boing 767", 300))
                .from(new Destination("GRZ", austria))
                .to(new Destination("VIE", austria))
                .departureTime(LocalDateTime.now().plusDays(1))
                .arrivalTime(LocalDateTime.now().plusDays(1).plusMinutes(30))
                .flightNumber("AUA201")
                .operator(aua).build();

        repository.saveAndFlush(f);
    }
}

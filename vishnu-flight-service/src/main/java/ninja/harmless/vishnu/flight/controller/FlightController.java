package ninja.harmless.vishnu.flight.controller;

import ninja.harmless.vishnu.flight.model.entity.Flight;
import ninja.harmless.vishnu.flight.model.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
package ninja.harmless.vishnu.controller;

import ninja.harmless.vishnu.common.api.FlightAware;
import ninja.harmless.vishnu.common.resource.RawFlightResource;
import ninja.harmless.vishnu.repository.ReactiveFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * @author bnjm@harmless.ninja - 7/31/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}/flightmonitoring")
public class MonitoringController implements FlightAware {

    private ReactiveFlightRepository repository;

    @Autowired
    public MonitoringController(ReactiveFlightRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public Flux<ServerSentEvent<RawFlightResource>> streamAllResources() {
        return repository.findBy().map(flightResource -> ServerSentEvent
                .builder(flightResource).build());
    }

    @GetMapping("/{flightNumber}")
    public Flux<ServerSentEvent<RawFlightResource>> streamByFlightNumber(@PathVariable String flightNumber) {
        return repository.findByFlightNumber(flightNumber).map(rawFlightResource -> ServerSentEvent.builder(rawFlightResource).build());
    }

    @Override
    @PostMapping
    public ResponseEntity<RawFlightResource> handleFlightResource(@RequestBody RawFlightResource requestBody) {
        repository.save(requestBody).subscribe();

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

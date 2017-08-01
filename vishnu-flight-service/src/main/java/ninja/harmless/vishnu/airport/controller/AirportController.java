package ninja.harmless.vishnu.airport.controller;

import ninja.harmless.vishnu.airport.model.AirportDataService;
import ninja.harmless.vishnu.common.controller.GenericCrudController;
import ninja.harmless.vishnu.common.data.DataService;
import ninja.harmless.vishnu.common.resource.AirportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}/airport")
public class AirportController extends GenericCrudController<AirportResource> {
    public AirportController(DataService<AirportResource> dataService) {
        super(dataService);
    }

    @GetMapping(params = "iata", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportResource> findByIataCode(@RequestParam String iata) {
        AirportDataService dataService = (AirportDataService) this.dataService;

        return new ResponseEntity<AirportResource>(dataService.findByIataCode(iata), HttpStatus.OK);
    }
}

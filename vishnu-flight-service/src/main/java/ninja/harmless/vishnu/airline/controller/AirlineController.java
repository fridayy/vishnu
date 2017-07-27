package ninja.harmless.vishnu.airline.controller;

import ninja.harmless.vishnu.airline.model.AirlineDataService;
import ninja.harmless.vishnu.common.controller.GenericCrudController;
import ninja.harmless.vishnu.common.resource.AirlineResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}/airline")
public class AirlineController extends GenericCrudController<AirlineResource> {
    @Autowired
    public AirlineController(AirlineDataService dataService) {
        super(dataService);
    }

  @GetMapping(params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AirlineResource> getByName(@RequestParam String name) {
    AirlineDataService dataService = (AirlineDataService) this.dataService;

    return new ResponseEntity<>(dataService.findOneByName(name), HttpStatus.OK);
  }
}

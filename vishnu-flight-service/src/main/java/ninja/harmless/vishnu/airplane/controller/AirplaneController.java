package ninja.harmless.vishnu.airplane.controller;

import ninja.harmless.vishnu.airplane.model.AirplaneDataService;
import ninja.harmless.vishnu.common.controller.GenericCrudController;
import ninja.harmless.vishnu.common.data.DataService;
import ninja.harmless.vishnu.common.resource.AirplaneResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}/airplane")
public class AirplaneController extends GenericCrudController<AirplaneResource> {
    @Autowired
    public AirplaneController(DataService<AirplaneResource> dataService) {
        super(dataService);
    }

    @GetMapping(params = "type", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirplaneResource> findByType(String type) {
      AirplaneDataService dataService = (AirplaneDataService) this.dataService;

      return new ResponseEntity<>(dataService.findByTypeDeclaration(type), HttpStatus.OK);
    }
}

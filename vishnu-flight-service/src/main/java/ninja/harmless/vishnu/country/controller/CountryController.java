package ninja.harmless.vishnu.country.controller;

import ninja.harmless.vishnu.common.controller.GenericCrudController;
import ninja.harmless.vishnu.common.resource.CountryResource;
import ninja.harmless.vishnu.country.model.CountryDataService;
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
@RequestMapping("${api.version}/country")
public class CountryController extends GenericCrudController<CountryResource> {

    @Autowired
    public CountryController(CountryDataService dataService) {
        super(dataService);
    }

    @GetMapping(params = "code", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryResource> getCountryByCountryCode(@RequestParam String code) {
        CountryDataService countryDataService = (CountryDataService) dataService;

        return new ResponseEntity<>(countryDataService.findByCountryCode(code), HttpStatus.OK);
    }
}

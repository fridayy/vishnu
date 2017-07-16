package ninja.harmless.vishnu.airport.controller;

import ninja.harmless.vishnu.common.controller.GenericCrudController;
import ninja.harmless.vishnu.common.data.DataService;
import ninja.harmless.vishnu.common.resource.AirportResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}/airport")
public class AirportContoller extends GenericCrudController<AirportResource> {
    public AirportContoller(DataService<AirportResource> dataService) {
        super(dataService);
    }
}

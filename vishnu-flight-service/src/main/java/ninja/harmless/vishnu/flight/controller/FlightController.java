package ninja.harmless.vishnu.flight.controller;

import ninja.harmless.vishnu.common.controller.GenericCrudController;
import ninja.harmless.vishnu.common.data.DataService;
import ninja.harmless.vishnu.common.resource.FlightResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}/flight")
public class FlightController extends GenericCrudController<FlightResource> {

    @Autowired
    public FlightController(DataService<FlightResource> dataService) {
        super(dataService);
    }
}
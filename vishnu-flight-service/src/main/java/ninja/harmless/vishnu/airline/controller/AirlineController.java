package ninja.harmless.vishnu.airline.controller;

import ninja.harmless.vishnu.common.controller.GenericCrudController;
import ninja.harmless.vishnu.common.data.DataService;
import ninja.harmless.vishnu.common.resource.AirlineResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}/airline")
public class AirlineController extends GenericCrudController<AirlineResource> {
    @Autowired
    public AirlineController(DataService<AirlineResource> dataService) {
        super(dataService);
    }
}

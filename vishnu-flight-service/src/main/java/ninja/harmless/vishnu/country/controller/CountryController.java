package ninja.harmless.vishnu.country.controller;

import ninja.harmless.vishnu.common.controller.GenericCrudController;
import ninja.harmless.vishnu.common.data.DataService;
import ninja.harmless.vishnu.common.resource.CountryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}/country")
public class CountryController extends GenericCrudController<CountryResource> {

    @Autowired
    public CountryController(DataService<CountryResource> dataService) {
        super(dataService);
    }
}

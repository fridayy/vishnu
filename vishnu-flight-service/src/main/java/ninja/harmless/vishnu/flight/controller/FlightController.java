package ninja.harmless.vishnu.flight.controller;

import ninja.harmless.vishnu.common.api.FlightMonitoringServiceFeignClient;
import ninja.harmless.vishnu.common.controller.GenericCrudController;
import ninja.harmless.vishnu.common.converter.FlightConverter;
import ninja.harmless.vishnu.common.data.DataService;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassembler;
import ninja.harmless.vishnu.common.resource.FlightResource;
import ninja.harmless.vishnu.flight.model.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author bnjm@harmless.ninja - 7/10/17.
 */
@RestController
@CrossOrigin
@RequestMapping("${api.version}/flight")
public class FlightController extends GenericCrudController<FlightResource> {

    private FlightMonitoringServiceFeignClient flightMonitoringServiceFeignClient;
    private ResourceDisassembler<FlightResource, Flight> disassembler;

    @Autowired
    public FlightController(DataService<FlightResource> dataService,
                            FlightMonitoringServiceFeignClient flightMonitoringServiceFeignClient,
                            ResourceDisassembler<FlightResource, Flight> disassembler) {
        super(dataService);
        this.flightMonitoringServiceFeignClient = flightMonitoringServiceFeignClient;
        this.disassembler = disassembler;
    }

    @Override
    @PostMapping
    public ResponseEntity<FlightResource> insert(@RequestBody FlightResource body) {
        ResponseEntity<FlightResource> obj = super.insert(body);
        FlightConverter converter = new FlightConverter();
        flightMonitoringServiceFeignClient.handleFlightResource(converter.convert(body));

        return obj;
    }
}

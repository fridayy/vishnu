package ninja.harmless.vishnu.simulation;

import ninja.harmless.vishnu.common.api.FlightServiceFeignClient;
import ninja.harmless.vishnu.common.geo.GeoCalculation;
import ninja.harmless.vishnu.common.resource.LatLon;
import ninja.harmless.vishnu.common.resource.RawFlightResource;
import ninja.harmless.vishnu.repository.ReactiveFlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * @author bnjm@harmless.ninja - 8/7/17.
 */
@Component
public class FlightMovementSimulation {

    private final ReactiveFlightRepository repository;
    private final FlightServiceFeignClient flightServiceFeignClient;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public FlightMovementSimulation(ReactiveFlightRepository repository, FlightServiceFeignClient flightServiceFeignClient) {
        this.repository = repository;
        this.flightServiceFeignClient = flightServiceFeignClient;
    }

    @Autowired


    /**
     * Simulates the path of an "in flight" {@link RawFlightResource}. This is done by calculating the next projected
     * {@link LatLon} coordinate. For each step a new {@link RawFlightResource} is created in the capped mongo collection.
     */
    @Scheduled(fixedRate = 2000)
    public void simulateMovement() {
        // get all resources and group them by the flight number
        repository.findAll().groupBy(RawFlightResource::getFlightNumber).subscribe(groupedObs -> {
            //take the last from each grouped observable and update their flight path by creating a copy with the new lat lon
            groupedObs.takeLast(1).subscribe(rawFlightResource -> {
                if (!hasArrived(rawFlightResource.getLatLon(), rawFlightResource.getTo().getLatLon())) {
                    RawFlightResource resource = new RawFlightResource(rawFlightResource);
                    LatLon next = GeoCalculation.calculateProjectedPosition(rawFlightResource.getLatLon(), rawFlightResource.getTo().getLatLon());
                    resource.setLatLon(next);
                    repository.save(resource).subscribe();
                } else {
                    //update the flight status and send it to the flight service
                    rawFlightResource.setStatus("landed");
                    flightServiceFeignClient.updateResource(rawFlightResource);
                }
            });
        });
    }

    public boolean hasArrived(LatLon current, LatLon target) {
        DecimalFormat df = new DecimalFormat("###.##");
        return Objects.equals(Double.valueOf(df.format(current.getLat())), Double.valueOf(df.format(target.getLat()))) &&
                Objects.equals(Double.valueOf(df.format(current.getLon())), Double.valueOf(df.format(target.getLon())));
    }
}

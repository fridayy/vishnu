package ninja.harmless.vishnu.simulation;

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

    private ReactiveFlightRepository repository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public FlightMovementSimulation(ReactiveFlightRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 2000)
    public void simulateMovement() {
        repository.findAll().takeLast(1).subscribe(rawFlightResource -> {
            if (!hasArrived(rawFlightResource.getLatLon(), rawFlightResource.getTo().getLatLon())) {
                RawFlightResource resource = new RawFlightResource(rawFlightResource);
                LatLon next = GeoCalculation.calculateProjectedPosition(rawFlightResource.getLatLon(), rawFlightResource.getTo().getLatLon());
                resource.setLatLon(next);
                repository.save(resource).subscribe();
            }
        });
    }

    public boolean hasArrived(LatLon current, LatLon target) {
        DecimalFormat df = new DecimalFormat("###.##");
        return Objects.equals(Double.valueOf(df.format(current.getLat())), Double.valueOf(df.format(target.getLat()))) &&
                Objects.equals(Double.valueOf(df.format(current.getLon())), Double.valueOf(df.format(target.getLon())));
    }
}

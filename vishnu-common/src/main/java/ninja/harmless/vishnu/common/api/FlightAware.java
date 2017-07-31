package ninja.harmless.vishnu.common.api;

import ninja.harmless.vishnu.common.resource.RawFlightResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Marks an {@link org.springframework.web.bind.annotation.RestController} as flight aware. This means the Controller
 * implementing this interface will know how to handle incoming {@link ninja.harmless.vishnu.common.resource.FlightResource}'s
 * and react accordingly.
 *
 * @author bnjm@harmless.ninja - 7/31/17.
 */
public interface FlightAware {
    ResponseEntity<RawFlightResource> handleFlightResource(@RequestBody RawFlightResource requestBody);
}

package ninja.harmless.vishnu.common.api;

import ninja.harmless.vishnu.common.resource.RawFlightResource;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author bnjm@harmless.ninja - 7/31/17.
 */
@FeignClient("vishnu-flight-monitoring-service")
public interface FlightMonitoringServiceFeignClient {
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/v1/flightmonitoring"
    )
    ResponseEntity<RawFlightResource> handleFlightResource(@RequestBody RawFlightResource requestBody);
}

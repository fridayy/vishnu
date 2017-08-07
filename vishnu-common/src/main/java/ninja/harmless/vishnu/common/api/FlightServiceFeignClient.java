package ninja.harmless.vishnu.common.api;

import ninja.harmless.vishnu.common.resource.CountryResource;
import ninja.harmless.vishnu.common.resource.RawFlightResource;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Provides the vishnu-flight-service feign client api for all services
 *
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@FeignClient("vishnu-flight-service")
public interface FlightServiceFeignClient {
    @RequestMapping(
            method = GET,
            value = "/v1/country",
            params = "code"
    )
    CountryResource getCountryByCountryCode(@RequestParam(name = "code") String countryCode);

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/v1/flight",
            consumes = APPLICATION_JSON_VALUE
    )
    ResponseEntity<RawFlightResource> updateResource(RawFlightResource resource);
}

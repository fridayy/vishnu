package ninja.harmless.vishnu.common.api;

import ninja.harmless.vishnu.common.resource.CountryResource;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Provides the vishnu-flight-service feign client api for all services
 *
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@FeignClient("vishnu-flight-service")
public interface FlightServiceFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v1/country",
            params = "code"
    )
    CountryResource getCountryByCountryCode(@RequestParam(name = "code") String countryCode);
}

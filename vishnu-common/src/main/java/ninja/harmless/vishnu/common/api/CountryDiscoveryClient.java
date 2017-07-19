package ninja.harmless.vishnu.common.api;

import ninja.harmless.vishnu.common.api.exception.ServiceUnreachableException;
import ninja.harmless.vishnu.common.resource.CountryResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Showcases a usage example of the standard discovery client. However this approach is not ideal since it does not take advantage
 * of client-side load balancing (ribbon)
 *
 * @deprecated
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Component
@Deprecated
public class CountryDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final  String VISHNU_FLIGHT_SERVICE = "vishnu-flight-service";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CountryResource getCountryByCountryCode(String code) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances(VISHNU_FLIGHT_SERVICE);
        if (instances == null) {
            logger.error("No instance of {0} is reachable!", VISHNU_FLIGHT_SERVICE);
            throw new ServiceUnreachableException("No " + VISHNU_FLIGHT_SERVICE + "is currently available");
        }
        ResponseEntity<CountryResource> restExchange = restTemplate.getForEntity(
                instances.get(0).getUri().toString() + "/v1/country?code=" + code, CountryResource.class);

        return restExchange.getBody();
    }
}

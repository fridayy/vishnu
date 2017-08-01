package ninja.harmless.vishnu;

import ninja.harmless.vishnu.common.api.CountryDiscoveryClient;
import ninja.harmless.vishnu.common.api.FlightServiceFeignClient;
import ninja.harmless.vishnu.common.bootstrap.BootstrapEurekaClient;
import ninja.harmless.vishnu.common.resource.CountryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@BootstrapEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class BootstrapPassengerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapPassengerServiceApplication.class, args);
    }
}


@RestController
class Controller {

    @Autowired
    CountryDiscoveryClient discoveryClient;

    @Autowired
    FlightServiceFeignClient feignClient;

    @GetMapping("/")
    public Mono<CountryResource> getPassenger() {
        CountryResource c = feignClient.getCountryByCountryCode("AT");
        return Mono.just(c);
    }
}
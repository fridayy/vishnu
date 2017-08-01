package ninja.harmless.vishnu;

import ninja.harmless.vishnu.common.bootstrap.BootstrapEurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@BootstrapEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class BootstrapFlightServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapFlightServiceApplication.class, args);
    }
}
package ninja.harmless.vishnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
public class BootstrapFlightMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapFlightMonitoringApplication.class, args);
    }
}

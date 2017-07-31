package ninja.harmless.vishnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableDiscoveryClient
@EnableFeignClients
public class BootstrapFlightMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstrapFlightMonitoringApplication.class, args);
	}
}

package ninja.harmless.vishnu.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author bnjm@harmless.ninja - 6/11/17.
 */
@SpringBootApplication
@EnableEurekaServer
public class BootstrapDiscovery {
    public static void main(String[] args) {
        SpringApplication.run(BootstrapDiscovery.class, args);
    }
}

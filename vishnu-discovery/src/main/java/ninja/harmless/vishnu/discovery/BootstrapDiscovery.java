package ninja.harmless.vishnu.discovery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author bnjm@harmless.ninja - 6/11/17.
 */
@SpringBootApplication
@EnableEurekaServer
public class BootstrapDiscovery {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BootstrapDiscovery.class).properties("spring.application.name=vishnu-discovery").run(args);
    }
}

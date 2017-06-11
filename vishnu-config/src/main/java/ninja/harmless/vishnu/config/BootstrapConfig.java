package ninja.harmless.vishnu.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Bootstrapping class for the Vishnu configuration server.
 *
 * @author bnjm@harmless.ninja - 6/11/17.
 */
@EnableConfigServer
@SpringBootApplication
@EnableEurekaClient
public class BootstrapConfig {
    public static void main(String[] args) {
        SpringApplication.run(BootstrapConfig.class, args);
    }
}

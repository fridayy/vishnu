package ninja.harmless.vishnu.config;

import ninja.harmless.vishnu.common.bootstrap.SpringBootEurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Bootstrapping class for the Vishnu configuration server.
 *
 * @author bnjm@harmless.ninja - 6/11/17.
 */
@EnableConfigServer
@SpringBootEurekaClient
public class BootstrapConfig {
    public static void main(String[] args) {
        SpringApplication.run(BootstrapConfig.class, args);
    }
}

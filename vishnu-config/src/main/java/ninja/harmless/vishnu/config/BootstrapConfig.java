package ninja.harmless.vishnu.config;

import ninja.harmless.vishnu.common.bootstrap.BootstrapEurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Bootstrapping class for the Vishnu configuration server.
 *
 * @author bnjm@harmless.ninja - 6/11/17.
 */
@EnableConfigServer
@BootstrapEurekaClient
public class BootstrapConfig {
    public static void main(String[] args) {
        SpringApplication.run(BootstrapConfig.class, args);
    }
}

package ninja.harmless.vishnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableEurekaClient
public class BootstrapZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapZipkinApplication.class, args);
    }
}

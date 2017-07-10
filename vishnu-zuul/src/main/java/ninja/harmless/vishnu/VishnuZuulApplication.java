package ninja.harmless.vishnu;

import ninja.harmless.vishnu.common.bootstrap.SpringBootEurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootEurekaClient
@EnableZuulProxy
public class VishnuZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(VishnuZuulApplication.class, args);
	}
}

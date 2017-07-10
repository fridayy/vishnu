package ninja.harmless.vishnu;

import ninja.harmless.vishnu.common.bootstrap.BootstrapEurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@BootstrapEurekaClient
public class BootstrapPassengerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstrapPassengerServiceApplication.class, args);
	}
}


class Passenger {
	public String name;

	public Passenger(String name) {
		this.name = name;
	}
}

@RestController
class Controller {
	@GetMapping("/")
	public Mono<Passenger> getPassenger() {
		Passenger p = new Passenger("Heinrich");
		return Mono.just(p);
	}
}
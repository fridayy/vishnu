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

	public String isTransient;

	public Passenger(String name, String isTransient) {
		this.name = name;
		this.isTransient = isTransient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsTransient() {
		return isTransient;
	}

	public void setIsTransient(String isTransient) {
		this.isTransient = isTransient;
	}
}

@RestController
class Controller {
	@GetMapping("/")
	public Mono<Passenger> getPassenger() {
		Passenger p = new Passenger("Heinrich", "sadjhasjkdas");
		return Mono.just(p);
	}
}
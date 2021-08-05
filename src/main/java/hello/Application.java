package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

	@RequestMapping("/hello")
	public String hello() {
		try {
			Thread.sleep((long)(Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello Docker World";
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		Map<String, Object> properties = Map.of("logging.level.root", "DEBUG",
				"management.endpoint.env.enabled", false,
				"management.endpoint.health.group.liveness.include", "*",
				"management.endpoint.health.group.readiness.include", "*",
				"management.endpoint.health.show-details", "always",
				"management.endpoints.web.base-path", "/actuator",
				"management.endpoints.web.exposure.include", "*",
				"management.endpoints.web.path-mapping.health", "/health");
		application.setDefaultProperties(properties);
		application.run(args);
	}

}

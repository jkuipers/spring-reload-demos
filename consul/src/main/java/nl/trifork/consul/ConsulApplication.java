package nl.trifork.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulApplication.class, args);
	}

}

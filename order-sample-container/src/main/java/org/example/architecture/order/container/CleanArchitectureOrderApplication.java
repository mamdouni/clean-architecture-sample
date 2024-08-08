package org.example.architecture.order.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "org.example.architecture.order.infra.secondary.database"})
@EntityScan(basePackages = { "org.example.architecture.order.infra.secondary.database"})
@SpringBootApplication(scanBasePackages = {"org.example.architecture.order"})
public class CleanArchitectureOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchitectureOrderApplication.class, args);
	}

}

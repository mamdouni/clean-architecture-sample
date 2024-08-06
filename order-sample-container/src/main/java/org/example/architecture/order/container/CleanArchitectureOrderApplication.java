package org.example.architecture.order.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.architecture.order")
public class CleanArchitectureOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchitectureOrderApplication.class, args);
	}

}

package org.example.architecture.tzatziki.configurations;

import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.example.architecture.order.container.CleanArchitectureOrderApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CleanArchitectureOrderApplication.class)
@ContextConfiguration(initializers = TzatzikiSpringConfig.Initializer.class)
@ActiveProfiles({ "test" })
@Slf4j
public class TzatzikiSpringConfig {

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            // here you can initialize the context with the properties needed by your application.
        }
    }
}

package org.example.architecture.tzatziki.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "json:target/cucumber.json" },
        features = "classpath:features",
        glue = {"com.decathlon.tzatziki.steps", "org.example.architecture.tzatziki.steps", "org.example.architecture.tzatziki.configurations"},
        tags = "not @ignore"
)
public class CucumberRunnerTest {}

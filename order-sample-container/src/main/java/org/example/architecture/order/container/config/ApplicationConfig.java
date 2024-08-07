package org.example.architecture.order.container.config;

import jakarta.annotation.PostConstruct;
import java.time.ZoneOffset;
import java.util.TimeZone;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    /**
     * Set default time zone for dates to UTC.
     */
    @PostConstruct
    public void setTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
    }
}

package org.example.architecture.order.core.domain.product.config;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "application.product")
@Slf4j
public class ProductTypesConfigProperties {

    private List<String> types;
}

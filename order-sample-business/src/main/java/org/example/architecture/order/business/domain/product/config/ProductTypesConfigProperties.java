package org.example.architecture.order.business.domain.product.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "application.product")
@Slf4j
public class ProductTypesConfigProperties {

    private List<String> types;
}

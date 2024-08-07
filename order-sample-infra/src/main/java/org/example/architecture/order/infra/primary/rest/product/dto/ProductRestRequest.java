package org.example.architecture.order.infra.primary.rest.product.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRestRequest {

    private String name;
    private String description;
    private String type;
    private BigDecimal price;
    private String priceCurrency;
}

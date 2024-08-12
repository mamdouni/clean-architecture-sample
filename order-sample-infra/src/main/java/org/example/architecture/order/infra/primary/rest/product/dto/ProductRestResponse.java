package org.example.architecture.order.infra.primary.rest.product.dto;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRestResponse {

    private UUID id;
    private String name;
    private String type;
    private String description;
    private BigDecimal price;
    private String priceCurrency;
}

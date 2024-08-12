package org.example.architecture.order.business.domain.product.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Product {

    private UUID id;
    private String name;
    private String type;
    private String description;
    private BigDecimal price;
    private String priceCurrency;
}

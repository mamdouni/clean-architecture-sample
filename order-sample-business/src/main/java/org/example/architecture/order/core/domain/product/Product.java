package org.example.architecture.order.core.domain.product;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

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

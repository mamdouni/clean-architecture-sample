package org.example.architecture.order.infra.secondary.database.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity {

    @Id
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String priceCurrency;
}

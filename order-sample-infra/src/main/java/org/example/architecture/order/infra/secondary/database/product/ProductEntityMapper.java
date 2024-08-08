package org.example.architecture.order.infra.secondary.database.product;

import org.example.architecture.order.core.domain.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

        ProductEntity mapDomainToEntity(Product product);

        Product mapEntityToDomain(ProductEntity productEntity);
}

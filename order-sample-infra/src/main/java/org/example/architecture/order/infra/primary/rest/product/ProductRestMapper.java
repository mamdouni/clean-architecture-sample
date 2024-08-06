package org.example.architecture.order.infra.primary.rest.product;

import org.example.architecture.order.core.domain.product.Product;
import org.example.architecture.order.infra.primary.rest.product.dto.ProductRestResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRestMapper {

    ProductRestResponse mapDomainToRest(Product product);

    Product mapRestToDomain(ProductRestResponse productRest);
}

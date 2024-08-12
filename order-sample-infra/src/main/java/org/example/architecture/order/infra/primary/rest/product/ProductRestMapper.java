package org.example.architecture.order.infra.primary.rest.product;

import org.example.architecture.order.business.domain.product.domain.Product;
import org.example.architecture.order.infra.primary.rest.product.dto.ProductRestRequest;
import org.example.architecture.order.infra.primary.rest.product.dto.ProductRestResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRestMapper {

    ProductRestResponse mapDomainToRestResponse(Product product);
    ProductRestRequest mapDomainToRestRequest(Product product);

    Product mapRestResponseToDomain(ProductRestResponse productRest);
    Product mapRestRequestToDomain(ProductRestRequest productRest);
}

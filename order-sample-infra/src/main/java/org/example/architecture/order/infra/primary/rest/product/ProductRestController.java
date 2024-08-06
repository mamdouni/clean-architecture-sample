package org.example.architecture.order.infra.primary.rest.product;

import java.util.List;
import lombok.AllArgsConstructor;
import org.example.architecture.order.core.application.product.ports.inputs.ProductReadUseCases;
import org.example.architecture.order.infra.primary.rest.product.dto.ProductRestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductRestController {

    private final ProductReadUseCases productReadUseCases;
    private final ProductRestMapper productRestMapper;

    @GetMapping
    @ResponseStatus(OK)
    public List<ProductRestResponse> getAllProducts() {

        return productReadUseCases.getAllProducts().stream()
                .map(productRestMapper::mapDomainToRest)
                .toList();
    }

}

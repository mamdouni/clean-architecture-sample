package org.example.architecture.order.infra.primary.rest.product;

import lombok.AllArgsConstructor;
import org.example.architecture.order.business.application.product.ports.inputs.CreateProductUseCase;
import org.example.architecture.order.business.application.product.ports.inputs.ProductReadUseCases;
import org.example.architecture.order.infra.primary.rest.product.dto.ProductRestRequest;
import org.example.architecture.order.infra.primary.rest.product.dto.ProductRestResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductRestController {

    private final ProductReadUseCases productReadUseCases;
    private final CreateProductUseCase createProductUseCase;
    private final ProductRestMapper productRestMapper;

    @GetMapping
    @ResponseStatus(OK)
    public List<ProductRestResponse> getAllProducts() {

        return productReadUseCases.getAllProducts().stream()
                .map(productRestMapper::mapDomainToRestResponse)
                .toList();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ProductRestResponse createProduct(@RequestBody ProductRestRequest productRestRequest) {

        return productRestMapper.mapDomainToRestResponse(
                createProductUseCase.createProduct(
                        productRestMapper.mapRestRequestToDomain(productRestRequest)
                )
        );
    }

}

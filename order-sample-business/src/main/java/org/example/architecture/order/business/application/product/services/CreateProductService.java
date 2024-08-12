package org.example.architecture.order.business.application.product.services;

import lombok.AllArgsConstructor;
import org.example.architecture.order.business.application.product.ports.inputs.CreateProductUseCase;
import org.example.architecture.order.business.domain.product.domain.Product;
import org.example.architecture.order.business.domain.product.ports.outputs.ProductPersistenceOutputPort;
import org.example.architecture.order.business.domain.product.rules.ValidateOrderCreationBusinessRule;
import org.example.architecture.order.business.domain.product.rules.ValidateOrderUniquenessBusinessRule;
import org.example.architecture.order.business.domain.product.rules.ValidateProductTypeBusinessRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final ValidateOrderCreationBusinessRule validateOrderCreationBusinessRule;
    private final ValidateProductTypeBusinessRule validateProductTypeBusinessRule;
    private final ValidateOrderUniquenessBusinessRule validateOrderUniquenessBusinessRule;
    private final ProductPersistenceOutputPort productPersistenceOutputPort;

    @Override
    public Product createProduct(Product product) {

        product = validateOrderCreationBusinessRule
                .compose(validateProductTypeBusinessRule)
                .compose(validateOrderUniquenessBusinessRule)
                .apply(product);
        product.setId(UUID.randomUUID());
        return productPersistenceOutputPort.saveProduct(product);
    }

}

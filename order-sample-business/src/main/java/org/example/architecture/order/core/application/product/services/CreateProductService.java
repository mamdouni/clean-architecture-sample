package org.example.architecture.order.core.application.product.services;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.example.architecture.order.core.application.product.ports.inputs.CreateProductUseCase;
import org.example.architecture.order.core.domain.product.Product;
import org.example.architecture.order.core.domain.product.ports.outputs.ProductPersistenceOutputPort;
import org.example.architecture.order.core.domain.product.rules.ValidateOrderCreationBusinessRule;
import org.example.architecture.order.core.domain.product.rules.ValidateOrderUniquenessBusinessRule;
import org.example.architecture.order.core.domain.product.rules.ValidateProductTypeBusinessRule;
import org.springframework.stereotype.Service;

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

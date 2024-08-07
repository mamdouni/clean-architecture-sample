package org.example.architecture.order.core.domain.product.rules;

import java.util.function.UnaryOperator;
import lombok.AllArgsConstructor;
import org.example.architecture.order.core.application.product.ports.outputs.ProductPersistenceOutputPort;
import org.example.architecture.order.core.domain.product.Product;
import org.example.architecture.order.core.domain.product.exceptions.OrderCreationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidateOrderUniquenessBusinessRule implements UnaryOperator<Product> {

    private final ProductPersistenceOutputPort productPersistenceOutputPort;

    @Override
    public Product apply(Product product) {

        if(productPersistenceOutputPort.findProductByName(product.getName()).isPresent())
            throw new OrderCreationException("Product name already exists");
        return product;
    }

}

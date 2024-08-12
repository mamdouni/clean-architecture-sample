package org.example.architecture.order.business.domain.product.rules;

import lombok.AllArgsConstructor;
import org.example.architecture.order.business.domain.product.domain.Product;
import org.example.architecture.order.business.domain.product.exceptions.OrderCreationException;
import org.example.architecture.order.business.domain.product.ports.outputs.ProductPersistenceOutputPort;
import org.springframework.stereotype.Service;

import java.util.function.UnaryOperator;

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

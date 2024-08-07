package org.example.architecture.order.core.domain.product.rules;

import java.util.function.UnaryOperator;
import lombok.AllArgsConstructor;
import org.example.architecture.order.core.domain.product.Product;
import org.example.architecture.order.core.domain.product.config.ProductTypesConfigProperties;
import org.example.architecture.order.core.domain.product.exceptions.OrderCreationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidateProductTypeBusinessRule implements UnaryOperator<Product> {

    private final ProductTypesConfigProperties productTypesConfigProperties;

    @Override
    public Product apply(Product product) {

        if(productTypesConfigProperties.getTypes().contains(product.getType()))
            return product;
        else
            throw new OrderCreationException("Product type is not supported");
    }

}

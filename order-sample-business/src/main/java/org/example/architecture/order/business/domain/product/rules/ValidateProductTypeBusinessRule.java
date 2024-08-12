package org.example.architecture.order.business.domain.product.rules;

import lombok.AllArgsConstructor;
import org.example.architecture.order.business.domain.product.config.ProductTypesConfigProperties;
import org.example.architecture.order.business.domain.product.domain.Product;
import org.example.architecture.order.business.domain.product.exceptions.OrderCreationException;
import org.springframework.stereotype.Service;

import java.util.function.UnaryOperator;

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

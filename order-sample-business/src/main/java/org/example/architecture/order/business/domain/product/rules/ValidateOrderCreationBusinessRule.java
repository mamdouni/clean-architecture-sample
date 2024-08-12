package org.example.architecture.order.business.domain.product.rules;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.example.architecture.order.business.domain.product.domain.Product;
import org.example.architecture.order.business.domain.product.exceptions.OrderCreationException;
import org.springframework.stereotype.Service;

import java.util.function.UnaryOperator;

@Service
@AllArgsConstructor
public class ValidateOrderCreationBusinessRule implements UnaryOperator<Product> {

    private final ValidateProductCurrencyBusinessRule validateProductCurrencyBusinessRule;

    @Override
    public Product apply(Product product) {

        if(StringUtils.isBlank(product.getDescription()))
            throw new OrderCreationException("Order description is required");
        if (StringUtils.isBlank(product.getName()))
            throw new OrderCreationException("Order name is required");
        if (product.getPrice() == null)
            throw new OrderCreationException("Order price is required");

        return validateProductCurrencyBusinessRule.apply(product);
    }

}

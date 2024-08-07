package org.example.architecture.order.core.domain.product.rules;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import org.example.architecture.order.core.domain.product.Product;
import org.example.architecture.order.core.domain.product.enums.PriceCurrencyEnum;
import org.example.architecture.order.core.domain.product.exceptions.OrderCurrencyException;
import org.springframework.stereotype.Service;

@Service
public class ValidateProductCurrencyBusinessRule implements UnaryOperator<Product> {

    @Override
    public Product apply(Product product) {
        if(Arrays.asList(PriceCurrencyEnum.EUR.name(), PriceCurrencyEnum.USD.name()).contains(product.getPriceCurrency()))
            return product;
        else
            throw new OrderCurrencyException("Order currency is not supported");
    }

}

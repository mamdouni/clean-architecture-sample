package org.example.architecture.order.business.domain.product.rules;

import org.example.architecture.order.business.domain.product.domain.Product;
import org.example.architecture.order.business.domain.product.enums.PriceCurrencyEnum;
import org.example.architecture.order.business.domain.product.exceptions.OrderCurrencyException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.function.UnaryOperator;

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

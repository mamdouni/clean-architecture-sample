package org.example.architecture.order.core.domain.product.exceptions;

public class OrderCurrencyException extends RuntimeException{

    public OrderCurrencyException(String message) {
        super(message);
    }
}

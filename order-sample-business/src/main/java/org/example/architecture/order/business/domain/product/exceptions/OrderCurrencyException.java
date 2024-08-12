package org.example.architecture.order.business.domain.product.exceptions;

public class OrderCurrencyException extends RuntimeException{

    public OrderCurrencyException(String message) {
        super(message);
    }
}

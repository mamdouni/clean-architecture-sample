package org.example.architecture.order.core.domain.product.exceptions;

public class OrderCreationException extends RuntimeException{

    public OrderCreationException(String message) {
        super(message);
    }

}

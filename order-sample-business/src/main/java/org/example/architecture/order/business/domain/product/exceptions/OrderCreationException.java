package org.example.architecture.order.business.domain.product.exceptions;

public class OrderCreationException extends RuntimeException{

    public OrderCreationException(String message) {
        super(message);
    }

}

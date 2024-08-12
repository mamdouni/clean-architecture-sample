package org.example.architecture.order.business.application.product.ports.inputs;

import org.example.architecture.order.business.domain.product.domain.Product;

import java.util.List;

public interface ProductReadUseCases {

    // to minimise the number of interfaces, we can define a port for the read operations and another for the write operations
    // but if you have a complicated scenario, you have to define a separate port and respect the SRP principle
    List<Product> getAllProducts();
}

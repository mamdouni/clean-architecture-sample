package org.example.architecture.order.core.application.product.ports.inputs;

import java.util.List;
import org.example.architecture.order.core.domain.product.Product;

public interface ProductReadUseCases {

    // to minimise the number of interfaces, we can define a port for the read operations and another for the write operations
    // but if you have a complicated scenario, you have to define a separate port and respect the SRP principle
    List<Product> getAllProducts();
}

package org.example.architecture.order.core.application.product.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.example.architecture.order.core.application.product.ports.inputs.ProductReadUseCases;
import org.example.architecture.order.core.domain.product.Product;
import org.example.architecture.order.core.domain.product.ports.outputs.ProductPersistenceOutputPort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductReadOperationsService implements ProductReadUseCases {

    private final ProductPersistenceOutputPort productPersistenceOutputPort;

    @Override
    public List<Product> getAllProducts() {
        return productPersistenceOutputPort.getAllProducts();
    }

}

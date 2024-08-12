package org.example.architecture.order.business.application.product.services;

import lombok.AllArgsConstructor;
import org.example.architecture.order.business.application.product.ports.inputs.ProductReadUseCases;
import org.example.architecture.order.business.domain.product.domain.Product;
import org.example.architecture.order.business.domain.product.ports.outputs.ProductPersistenceOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductReadOperationsService implements ProductReadUseCases {

    private final ProductPersistenceOutputPort productPersistenceOutputPort;

    @Override
    public List<Product> getAllProducts() {
        return productPersistenceOutputPort.getAllProducts();
    }

}

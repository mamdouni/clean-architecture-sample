package org.example.architecture.order.business.domain.product.ports.outputs;

import org.example.architecture.order.business.domain.product.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductPersistenceOutputPort {
    Product saveProduct(Product productPersistenceOutputData);

    List<Product> getAllProducts();

    Product getProductById(UUID id);

    Optional<Product> findProductByName(String name);

}

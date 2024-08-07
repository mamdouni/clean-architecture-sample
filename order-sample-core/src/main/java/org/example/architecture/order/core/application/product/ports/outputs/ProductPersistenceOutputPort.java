package org.example.architecture.order.core.application.product.ports.outputs;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.architecture.order.core.domain.product.Product;

public interface ProductPersistenceOutputPort {
    Product saveProduct(Product productPersistenceOutputData);

    List<Product> getAllProducts();

    Product getProductById(UUID id);

    Optional<Product> findProductByName(String name);

}

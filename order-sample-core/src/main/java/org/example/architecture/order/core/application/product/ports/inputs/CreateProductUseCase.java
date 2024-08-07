package org.example.architecture.order.core.application.product.ports.inputs;

import org.example.architecture.order.core.domain.product.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);

}

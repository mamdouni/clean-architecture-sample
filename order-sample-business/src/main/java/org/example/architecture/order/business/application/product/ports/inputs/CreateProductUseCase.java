package org.example.architecture.order.business.application.product.ports.inputs;

import org.example.architecture.order.business.domain.product.domain.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);

}

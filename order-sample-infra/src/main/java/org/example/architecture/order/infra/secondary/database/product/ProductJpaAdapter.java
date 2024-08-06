package org.example.architecture.order.infra.secondary.database.product;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.example.architecture.order.core.application.product.ports.outputs.ProductPersistenceOutputPort;
import org.example.architecture.order.core.domain.product.Product;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductJpaAdapter implements ProductPersistenceOutputPort {

    private final ProductJpaRepository productJpaRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public void saveProduct(Product product) {
        productJpaRepository.save(
                productEntityMapper.mapDomainToEntity(product)
        );
    }

    @Override
    public List<Product> getAllProducts() {
        return productJpaRepository.findAll().stream()
                .map(productEntityMapper::mapEntityToDomain)
                .toList();
    }

    @Override
    public Product getProductById(UUID id) {
        return productJpaRepository.findById(id)
                .map(productEntityMapper::mapEntityToDomain)
                .orElse(null);
    }

}

package org.example.architecture.order.infra.secondary.database.product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.example.architecture.order.core.domain.product.ports.outputs.ProductPersistenceOutputPort;
import org.example.architecture.order.core.domain.product.Product;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductJpaAdapter implements ProductPersistenceOutputPort {

    private final ProductJpaRepository productJpaRepository;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product saveProduct(Product product) {
        return productEntityMapper.mapEntityToDomain(
                productJpaRepository.save(
                        productEntityMapper.mapDomainToEntity(product)
                )
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

    @Override
    public Optional<Product> findProductByName(String name) {

        return productJpaRepository.findByName(name)
                .map(productEntityMapper::mapEntityToDomain)
                .or(Optional::empty);
    }

}

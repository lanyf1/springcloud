package com.microservice.store.product.mapper;

import com.microservice.store.infrastructure.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String productName);

}

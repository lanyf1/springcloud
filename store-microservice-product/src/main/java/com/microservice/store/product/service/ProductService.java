package com.microservice.store.product.service;

import com.microservice.store.infrastructure.domain.Product;

public interface ProductService {

    public Product getProductByName(String name);
}

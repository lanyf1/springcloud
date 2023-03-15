package com.microservice.store.product.service.impl;

import com.microservice.store.product.domain.Product;
import com.microservice.store.product.mapper.ProductRepository;
import com.microservice.store.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {


    @Resource
    private ProductRepository productRepository;


    public Product getProductByName(String productName){

        return productRepository.findByProductName(productName);
    }
}

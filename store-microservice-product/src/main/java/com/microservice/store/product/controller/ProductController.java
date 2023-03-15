package com.microservice.store.product.controller;

import com.microservice.store.infrastructure.response.ResponseResult;
import com.microservice.store.product.domain.Product;
import com.microservice.store.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;
    @GetMapping("/query/{name}")
    public ResponseResult<Product> getProduct(@PathVariable String name){
        return ResponseResult.success(productService.getProductByName(name));
    }

}

package com.microservice.store.product.controller;

import com.microservice.store.infrastructure.domain.Product;
import com.microservice.store.infrastructure.response.ResponseResult;
import com.microservice.store.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/query/{name}")
    public ResponseResult<Product> getProduct(@PathVariable String name) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseResult.success(productService.getProductByName(name));
    }


    @GetMapping("/hello")
    public ResponseResult<String> getHello() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseResult.success("hello");
    }


}

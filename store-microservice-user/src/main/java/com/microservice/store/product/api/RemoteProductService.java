package com.microservice.store.product.api;

import com.microservice.store.infrastructure.domain.Product;
import com.microservice.store.infrastructure.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "product" ,path = "/product")
public interface RemoteProductService {

    @GetMapping("/query/{name}")
    public ResponseResult<Product> getProduct(@PathVariable("name") String productName);


    @RequestMapping("/hello")
    public String getHello();
}

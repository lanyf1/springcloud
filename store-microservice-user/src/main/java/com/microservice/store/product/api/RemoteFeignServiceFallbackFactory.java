package com.microservice.store.product.api;

import com.microservice.store.infrastructure.domain.Product;
import com.microservice.store.infrastructure.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

@Slf4j
public class RemoteFeignServiceFallbackFactory implements FallbackFactory<RemoteProductService> {
    @Override
    public RemoteProductService create(Throwable cause) {

        log.error("异常原因:{}", cause.getMessage(), cause);
        return new RemoteProductService() {
            @Override
            public ResponseResult<Product> getProduct(String productName) {
                return ResponseResult.fail("fallback");
            }

            @Override
            public String getHello() {
                return "fallback";
            }
        };
    }
}

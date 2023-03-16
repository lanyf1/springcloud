package com.microservice.store.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ZZ087P672
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UsertApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsertApplication.class,args);
    }
}

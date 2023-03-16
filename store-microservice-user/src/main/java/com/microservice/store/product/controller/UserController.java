package com.microservice.store.product.controller;

import com.microservice.store.infrastructure.domain.Product;
import com.microservice.store.infrastructure.response.ResponseResult;
import com.microservice.store.product.api.RemoteProductService;
import com.microservice.store.product.domain.User;
import com.microservice.store.product.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RemoteProductService remoteProductService;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Resource
//    private RestTemplate restTemplate;
    @GetMapping("/query/{name}")
    public ResponseResult<User> getUser(@PathVariable String name){
        return ResponseResult.success(userService.getUserByName(name));
    }


    @GetMapping("/queryproduct/{name}")
    public ResponseResult<Product> getUserProduct(@PathVariable String name){
        return remoteProductService.getProduct(name);
    }

    @GetMapping("/hello")
    public ResponseResult<String> getHello(){

        return ResponseResult.success(remoteProductService.getHello());
    }

//    @GetMapping("/hello2")
//    public ResponseResult<String> getHello2(){
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("product");
//        ServiceInstance serviceInstance = serviceInstances.get(0);
//        System.out.println(serviceInstance.getHost());
//        System.out.println(serviceInstance.getPort());
//        System.out.println(serviceInstance.getServiceId());
//        System.out.println(serviceInstance.getInstanceId());
//        System.out.println(serviceInstance.toString());
//        //地址格式 服务名加 请求的地址
//        String forObject = restTemplate.getForObject("http://product/product/hello2", String.class);
//        return ResponseResult.success(forObject);
//    }

}

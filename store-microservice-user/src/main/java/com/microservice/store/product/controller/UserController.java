package com.microservice.store.product.controller;

import com.microservice.store.infrastructure.response.ResponseResult;
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
    @GetMapping("/query/{name}")
    public ResponseResult<User> getUser(@PathVariable String name){
        return ResponseResult.success(userService.getUserByName(name));
    }

}

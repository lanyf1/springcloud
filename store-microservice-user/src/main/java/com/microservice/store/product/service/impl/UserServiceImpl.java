package com.microservice.store.product.service.impl;

import com.microservice.store.product.domain.User;
import com.microservice.store.product.mapper.UserRepository;
import com.microservice.store.product.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserRepository userRepository;


    public User getUserByName(String productName){

        return userRepository.findByUserName(productName);
    }
}

package com.microservice.store.product.service;

import com.microservice.store.product.domain.User;

public interface UserService {

    public User getUserByName(String name);
}

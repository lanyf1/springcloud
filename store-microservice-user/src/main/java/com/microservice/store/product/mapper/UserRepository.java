package com.microservice.store.product.mapper;

import com.microservice.store.product.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

}

package com.microservice.store.product.domain;

import com.microservice.store.infrastructure.domain.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseDomain implements Serializable {

    public User(String userName, String passWord, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    @Column(nullable = false, unique = true, length = 20)
    private String userName;
    @Column(nullable = false, unique = true, length = 30)
    private String passWord;
    @Column(nullable = false)
    private String email;



}
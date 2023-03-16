package com.microservice.store.infrastructure.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseDomain implements Serializable {
    public Product(String productName, String description) {
        this.productName = productName;
        this.description = description;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    @Column(nullable = false, unique = true, length = 20)
    private String productName;
    @Column(nullable = false)
    private String description;



}
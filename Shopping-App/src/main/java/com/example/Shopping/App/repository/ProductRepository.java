package com.example.Shopping.App.repository;

import com.example.Shopping.App.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    Iterable<Product> findAllByOrderByProductId();
}

package com.example.Shopping.App.service;

import com.example.Shopping.App.model.Product;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ProductService {
    Iterable<Product> fetchAll();
    Product findById(int id);
    Product saveProduct(Product product);
}

package com.example.Shopping.App.controller;

import com.example.Shopping.App.model.Product;
import com.example.Shopping.App.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService prodService;

    @GetMapping("/inventory")
    public Iterable<Product> getAll(){
        return prodService.fetchAll();
    }
}

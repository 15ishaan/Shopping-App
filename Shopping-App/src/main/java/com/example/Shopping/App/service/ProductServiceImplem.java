package com.example.Shopping.App.service;


import com.example.Shopping.App.model.Product;
import com.example.Shopping.App.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplem implements  ProductService{

    @Autowired
    private ProductRepository repo;

    public Iterable<Product> fetchAll(){
        return repo.findAllByOrderByProductId();
    }

    public Product findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return repo.save(product);
    }
}

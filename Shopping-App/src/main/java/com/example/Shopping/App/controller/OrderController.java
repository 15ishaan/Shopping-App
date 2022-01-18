package com.example.Shopping.App.controller;

import com.example.Shopping.App.model.Order;
import com.example.Shopping.App.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private ProductService prodService;

    @PostMapping("/{userId}/order")
    public Order placeOrder(@PathVariable("userId") int id, @RequestParam("qty") int qty, @RequestParam("coupon") String coupon){
        Order obj = new Order();

    }
}

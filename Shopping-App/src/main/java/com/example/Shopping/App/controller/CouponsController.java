package com.example.Shopping.App.controller;

import com.example.Shopping.App.model.Coupons;
import com.example.Shopping.App.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CouponsController {

    @Autowired
    private CouponsService couponsService;

    @GetMapping("/fetchCoupons")
    public Iterable<Coupons> getAll(){
        return couponsService.fetchAll();
    }
}

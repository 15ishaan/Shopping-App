package com.example.Shopping.App.service;

import com.example.Shopping.App.model.Coupons;
import com.example.Shopping.App.model.Product;
import org.springframework.validation.annotation.Validated;


@Validated
public interface CouponsService {
    Iterable<Coupons> fetchAll();
}

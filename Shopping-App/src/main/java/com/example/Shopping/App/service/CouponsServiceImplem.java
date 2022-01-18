package com.example.Shopping.App.service;

import com.example.Shopping.App.model.Coupons;
import com.example.Shopping.App.repository.CouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponsServiceImplem implements CouponsService {

    @Autowired
    private CouponsRepository repo;

    public Iterable<Coupons> fetchAll() {
        return repo.findAllByOrderByCouponId();
    }
}

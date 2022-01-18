package com.example.Shopping.App.service;

import com.example.Shopping.App.model.UserCoupons;
import com.example.Shopping.App.repository.UserCouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCouponsServiceImplem implements UserCouponsService{

    @Autowired
    private UserCouponsRepository repo;

    @Override
    public UserCoupons findByUserIdAndCoupon(int id, String coupon) {
        return repo.findByUserIdAndCoupon(id, coupon);
    }
}

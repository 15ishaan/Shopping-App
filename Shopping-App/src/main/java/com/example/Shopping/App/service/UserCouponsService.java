package com.example.Shopping.App.service;

import com.example.Shopping.App.model.UserCoupons;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserCouponsService {
    UserCoupons findByUserIdAndCoupon(int id, String coupon);
}

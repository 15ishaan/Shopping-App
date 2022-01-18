package com.example.Shopping.App.repository;

import com.example.Shopping.App.model.UserCoupons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCouponsRepository extends JpaRepository<UserCoupons, Integer> {

    UserCoupons findByUserIdAndCoupon(int id, String coupon);
}

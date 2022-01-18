package com.example.Shopping.App.repository;

import com.example.Shopping.App.model.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponsRepository extends JpaRepository<Coupons, Integer> {

    Iterable<Coupons> findAllByOrderByCouponId();
}


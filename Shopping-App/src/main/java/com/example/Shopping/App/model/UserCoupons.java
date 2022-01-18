package com.example.Shopping.App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserCoupons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCouponsId;
    private int userId;
    private String coupon;
    private boolean validity;


    public UserCoupons() {

    }

    public UserCoupons(int userCouponsId, int userId, String coupon, boolean validity) {
        this.userCouponsId = userCouponsId;
        this.userId = userId;
        this.coupon = coupon;
        this.validity = validity;
    }

    public int getUserCouponsId() {
        return userCouponsId;
    }

    public void setUserCouponsId(int userCouponsId) {
        this.userCouponsId = userCouponsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
}

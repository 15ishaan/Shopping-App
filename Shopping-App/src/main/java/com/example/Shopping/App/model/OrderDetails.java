package com.example.Shopping.App.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int userId;
    private int quantity;
    private int amount;
    private String coupon;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public OrderDetails() {

    }

    public OrderDetails(int orderId, int userId, int quantity, int amount, String coupon, Date createdDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.quantity = quantity;
        this.amount = amount;
        this.coupon = coupon;
        this.createdDate = createdDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

package com.example.Shopping.App.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private int userId;
    private int orderId;
    private String status;
    private int amount;
    private String coupon;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Transactions() {

    }

    public Transactions(int transactionId, int userId, int orderId, String status, int amount, String coupon, Date createdDate) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.orderId = orderId;
        this.status = status;
        this.amount = amount;
        this.coupon = coupon;
        this.createdDate = createdDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
}


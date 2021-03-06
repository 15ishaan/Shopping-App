package com.example.Shopping.App.controller;

import com.example.Shopping.App.model.*;
import com.example.Shopping.App.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.Date;

@RestController
public class OrderController {

    @Autowired
    private ProductService prodService;

    @Autowired
    private UserCouponsService userCouponsService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private TransactionsService transactionsService;

    @PostMapping("/{userId}/order")
    public OrderDetails placeOrder(@PathVariable("userId") String userId, @RequestParam("qty") int qty, @RequestParam("coupon") String coupon) {
        OrderDetails obj = new OrderDetails();
        int id = registrationService.StringToInt(userId);
        UserCoupons userCoupons = userCouponsService.findByUserIdAndCoupon(id, coupon);
        Product prod = prodService.findById(1);

        int maximumQty = prod.getAvailable();
        if(qty < 1 || qty > maximumQty) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Quantity");
        }
        else if(userCoupons == null || !userCoupons.isValidity()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Coupon");
        }
        //finding Discount from coupon
        int discount = registrationService.StringToInt(coupon.substring(3));
        int amount = (prod.getPrice()*qty*(100-discount))/100;   // Calculating Amount to be Paid

        Date date = new Date();

        obj.setUserId(id);
        obj.setQuantity(qty);
        obj.setCoupon(coupon);
        obj.setAmount(amount);
        obj.setCreatedDate(date);
        orderDetailsService.saveOrderDetails(obj);
        return obj;
    }

    @PostMapping("/{userId}/{orderId}/pay")
    public Transactions checkout(@PathVariable("userId") String userId, @PathVariable("orderId") String orderId, @RequestParam("amount") int amount) {
        int uId = registrationService.StringToInt(userId);
        int oId = registrationService.StringToInt(orderId);
        User user = registrationService.fetchUserById(uId);
        OrderDetails orderDetails = orderDetailsService.findByUserIdAndOrderId(uId, oId);
        Transactions transaction = transactionsService.findByUserIdAndOrderIdAndStatus(uId, oId, "successful");
        Transactions obj = new Transactions();
        Date date = new Date();
        obj.setOrderId(oId);
        obj.setCreatedDate(date);
        obj.setUserId(uId);
        obj.setAmount(amount);

        if(orderDetails == null) {
            obj.setStatus("failed");
            transactionsService.saveTransaction(obj);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Payment Failed due to invalid order id");
        }

        UserCoupons userCoupons = userCouponsService.findByUserIdAndCoupon(uId, orderDetails.getCoupon());
        if(!userCoupons.isValidity()) {
            obj.setStatus("failed");
            obj.setCoupon(orderDetails.getCoupon());
            transactionsService.saveTransaction(obj);
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Invalid Coupon");
        }
        else if(transaction != null) {
            obj.setStatus("failed");
            obj.setCoupon(orderDetails.getCoupon());
            transactionsService.saveTransaction(obj);
            throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Order is already paid for");
        }
        else if(orderDetails.getAmount() != amount) {
            obj.setStatus("failed");
            obj.setCoupon(orderDetails.getCoupon());
            transactionsService.saveTransaction(obj);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Payment Failed as amount is invalid");
        }
        //assuming user to have specific bank balance
        else if(user.getBalance() < amount) {
            obj.setStatus("failed");
            obj.setCoupon(orderDetails.getCoupon());
            transactionsService.saveTransaction(obj);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Payment Failed from bank");
        }
        else {
            //updating Transaction Table
            obj.setStatus("successful");
            obj.setCoupon(orderDetails.getCoupon());
            transactionsService.saveTransaction(obj);

            //updating Product Table
            Product prod = prodService.findById(1);
            prod.setAvailable(prod.getAvailable() - orderDetails.getQuantity());
            prod.setOrdered(prod.getOrdered() + orderDetails.getQuantity());
            prodService.saveProduct(prod);

            //updating UserCoupon Table
            userCoupons.setValidity(false);
            userCouponsService.saveUserCoupons(userCoupons);

            //updating User Table
            user.setBalance(user.getBalance()-amount);
            registrationService.saveUser(user);

            //returning transaction object
            return obj;
        }
    }

    @GetMapping("/{userId}/orders")
    public Iterable<OrderDetails> getOrderDetails(@PathVariable("userId") String userId) {
        int id = registrationService.StringToInt(userId);
        return orderDetailsService.findByUserId(id);
    }

    @GetMapping("/{userId}/orders/{orderId}")
    public Iterable<Transactions> getTransactionDetails(@PathVariable("userId") String userId, @PathVariable("orderId") String orderId) {
        int uId = registrationService.StringToInt(userId);
        int oId = registrationService.StringToInt(orderId);
        OrderDetails orderDetails = orderDetailsService.findByUserIdAndOrderId(uId, oId);
        if(orderDetails == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order Not Found");
        }
        return transactionsService.findByUserIdAndOrderId(uId, oId);
    }

}

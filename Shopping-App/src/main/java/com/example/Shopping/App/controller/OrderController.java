package com.example.Shopping.App.controller;

import com.example.Shopping.App.model.OrderDetails;
import com.example.Shopping.App.model.Product;
import com.example.Shopping.App.model.User;
import com.example.Shopping.App.model.UserCoupons;
import com.example.Shopping.App.repository.OrderDetailsRepository;
import com.example.Shopping.App.service.OrderDetailsServiceImplem;
import com.example.Shopping.App.service.ProductService;
import com.example.Shopping.App.service.RegistrationService;
import com.example.Shopping.App.service.UserCouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@RestController
public class OrderController {

    @Autowired
    private ProductService prodService;

    @Autowired
    private UserCouponsService userCouponsService;

    @Autowired
    private OrderDetailsServiceImplem orderDetailsService;

    @PostMapping("/{userId}/order")
    public OrderDetails placeOrder(@PathVariable("userId") String userId, @RequestParam("qty") int qty, @RequestParam("coupon") String coupon) {
        OrderDetails obj = new OrderDetails();
        int id = Integer.valueOf(userId);
        UserCoupons userCoupons = userCouponsService.findByUserIdAndCoupon(id, coupon);
        Product prod = prodService.findById(1);

        int maximumQty = prod.getAvailable();
        if(qty < 1 || qty > maximumQty) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Quantity");
        }
        else if(userCoupons == null || !userCoupons.isValidity()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Coupon");
        }
        int discount = Integer.valueOf(coupon.substring(3));
        int amount = (prod.getPrice()*qty*(100-discount))/100;
        Date date = new Date();

        obj.setUserId(id);
        obj.setQuantity(qty);
        obj.setCoupon(coupon);
        obj.setAmount(amount);
        obj.setCreatedDate(date);
        orderDetailsService.saveOrderDetails(obj);
        return obj;
    }
}

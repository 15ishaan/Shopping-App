package com.example.Shopping.App.service;

import com.example.Shopping.App.model.OrderDetails;
import com.example.Shopping.App.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImplem implements OrderDetailsService{

    @Autowired
    private OrderDetailsRepository repo;

    public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
        return repo.save(orderDetails);
    }

    @Override
    public OrderDetails findByUserIdAndOrderId(int uId, int oId) {
        return repo.findByUserIdAndOrderId(uId, oId);
    }
}

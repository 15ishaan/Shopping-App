package com.example.Shopping.App.service;

import com.example.Shopping.App.model.OrderDetails;

public interface OrderDetailsService {
    OrderDetails saveOrderDetails(OrderDetails orderDetails);
    OrderDetails findByUserIdAndOrderId(int uId, int oId);
    Iterable<OrderDetails> findByUserId(int id);
}

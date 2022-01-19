package com.example.Shopping.App.repository;

import com.example.Shopping.App.model.OrderDetails;
import com.example.Shopping.App.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    OrderDetails findByUserIdAndOrderId(int uId, int id);
    Iterable<OrderDetails> findByUserId(int id);
}

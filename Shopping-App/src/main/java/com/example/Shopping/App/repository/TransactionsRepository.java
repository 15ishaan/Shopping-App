package com.example.Shopping.App.repository;

import com.example.Shopping.App.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    Transactions findByUserIdAndOrderIdAndAndStatus(int uId, int oId, String status);
    Iterable<Transactions> findByUserIdAndOrderId(int uId, int oId);
}

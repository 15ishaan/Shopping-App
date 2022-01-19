package com.example.Shopping.App.service;

import com.example.Shopping.App.model.Transactions;
import com.example.Shopping.App.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsServiceImplem implements TransactionsService{

    @Autowired
    private TransactionsRepository repo;

    public Transactions saveTransaction(Transactions transaction) {
        return repo.save(transaction);
    }

    @Override
    public Transactions findByUserIdAndOrderIdAndStatus(int uId, int oId, String status) {
        return repo.findByUserIdAndOrderIdAndAndStatus(uId, oId, status);
    }

    @Override
    public Iterable<Transactions> findByUserIdAndOrderId(int uId, int oId) {
        return repo.findByUserIdAndOrderId(uId, oId);
    }
}

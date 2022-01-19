package com.example.Shopping.App.service;

import com.example.Shopping.App.model.Transactions;

public interface TransactionsService {
    Transactions saveTransaction(Transactions transaction);
    Transactions findByUserIdAndOrderIdAndStatus(int uId, int oId, String status);
}

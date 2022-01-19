package com.example.Shopping.App.repository;

import com.example.Shopping.App.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

//For User Authentication
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
    ConfirmationToken findByTokenId(long tokenId);
}

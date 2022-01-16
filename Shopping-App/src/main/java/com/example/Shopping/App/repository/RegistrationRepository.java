package com.example.Shopping.App.repository;

import com.example.Shopping.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    User findById(int id);
}

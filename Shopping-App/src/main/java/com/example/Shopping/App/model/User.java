package com.example.Shopping.App.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NotNull(message = "Enter your first name")
    private String firstName;

    @NotNull(message = "Enter your last name")
    @Size(min = 3, max = 30)
    private String lastName;

    @NotNull(message = "Enter your email")
    private String username;

    @Size(min = 6, max = 30)
    private String password;
    private String confirmPassword;

    private boolean enabled;
    private String roles;
    private boolean OFF5;
    private boolean OFF10;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isOFF5() {
        return OFF5;
    }

    public void setOFF5(boolean OFF5) {
        this.OFF5 = OFF5;
    }

    public boolean isOFF10() {
        return OFF10;
    }

    public void setOFF10(boolean OFF10) {
        this.OFF10 = OFF10;
    }
}

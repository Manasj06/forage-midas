package com.jpmc.midascore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String currency;
    private float balance;

    // REQUIRED BY JPA
    public UserRecord() {
    }

    // REQUIRED BY TESTS (String, float)
    public UserRecord(String username, float balance) {
        this.username = username;
        this.currency = "USD";
        this.balance = balance;
    }

    // REQUIRED BY TESTS (String, String, float)
    public UserRecord(String username, String currency, float balance) {
        this.username = username;
        this.currency = currency;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("User[id=%s, username='%s', balance='%f']", id, username, balance);
    }
}

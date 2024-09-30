package com.banking.account;

public interface Account {
    String getAccountNumber();

    double getBalance();

    boolean withdraw(double money);

    void deposit(double money);
}

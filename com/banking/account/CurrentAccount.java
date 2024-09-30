package com.banking.account;

public class CurrentAccount implements Account {
    private final String accountNumber;
    private double balance;
    private final double overDraftLimit;

    public CurrentAccount(String accountNumber, double overDraftLimit) {
        this.accountNumber = accountNumber;
        this.overDraftLimit = overDraftLimit;
        this.balance = 0.0;
    }

    @Override
    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public boolean withdraw(double money) {
        if (money <= balance) {
            balance -= money;
            return true;
        }
        return false;
    }

    @Override
    public void deposit(double money) {
        this.balance += money;
    }
}

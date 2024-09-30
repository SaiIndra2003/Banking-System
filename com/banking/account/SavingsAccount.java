package com.banking.account;

public class SavingsAccount implements Account {

    private final String accountNumber;
    private double balance;
    private final int interestRate;

    public SavingsAccount(String accountNumber, int interest) {
        this.accountNumber = accountNumber;
        this.interestRate = interest;
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

    public void applyInterest() {
        balance += (balance * interestRate);
    }
}

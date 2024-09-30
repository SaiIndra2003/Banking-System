package com.banking.transaction;

import com.banking.account.Account;

public class DepositTransaction implements Transaction {
    private final Account bankAccount;
    private final double amount;

    public DepositTransaction(Account bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public String getTransactionDetails() {
        return "Deposited " + amount + " to account " + bankAccount.getAccountNumber();
    }

    @Override
    public boolean execute() {
        bankAccount.deposit(amount);
        System.out.println("Deposited money");
        return true;
    }
}

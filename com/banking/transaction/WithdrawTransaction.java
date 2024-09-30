package com.banking.transaction;

import com.banking.account.Account;

public class WithdrawTransaction implements Transaction {
    private final Account bankAccount;
    private final double amount;

    public WithdrawTransaction(Account bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public String getTransactionDetails() {
        return "Withdrew " + amount + " from account " + bankAccount.getAccountNumber();
    }

    @Override
    public boolean execute() {
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrew " + amount + " from account " + bankAccount.getAccountNumber());
            return true;
        } else {
            System.out.println("Insufficient balance in account " + bankAccount.getAccountNumber());
            return false;
        }
    }
}

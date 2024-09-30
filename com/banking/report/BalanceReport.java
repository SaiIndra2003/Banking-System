package com.banking.report;

import com.banking.account.Account;

// Concrete BalanceReport (SRP, OCP)
public class BalanceReport implements Report {

    @Override
    public void generate(Account account) {
        System.out.println("Balance for account " + account.getAccountNumber() + ": " + account.getBalance());
    }

}

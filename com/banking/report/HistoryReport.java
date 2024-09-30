package com.banking.report;

import com.banking.account.Account;
import com.banking.manager.TransactionManager;
import com.banking.transaction.Transaction;

import java.util.List;

public class HistoryReport implements Report {
    private final TransactionManager transactionManager;

    public HistoryReport(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public void generate(Account account) {
        List<String> transactions = transactionManager.getTransactionsForAccount(account.getAccountNumber());
        if (transactions.isEmpty()) {
            System.out.println("No transaction history for account " + account.getAccountNumber());
        } else {
            System.out.println("Transaction History for account " + account.getAccountNumber() + ":");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}

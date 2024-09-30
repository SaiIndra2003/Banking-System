package com.banking.manager;

import com.banking.account.Account;
import com.banking.transaction.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionManager {
    private final List<Transaction> transactionHistory;
    private final Map<String, List<Transaction>> accountTransactionMap;  // Map to track transactions by account number

    public TransactionManager() {
        this.transactionHistory = new ArrayList<>();
        this.accountTransactionMap = new HashMap<>();
    }

    // Execute transaction and record it against an account
    public void executeTransaction(Account account, Transaction transaction) {
        boolean success = transaction.execute();
        if (success) {
            transactionHistory.add(transaction);
            // Add the transaction to the specific account's transaction list
            accountTransactionMap.computeIfAbsent(account.getAccountNumber(), k -> new ArrayList<>()).add(transaction);
        }
    }

    // Get transactions for a specific account
    public List<Transaction> getTransactionsForAccount(String accountNumber) {
        return accountTransactionMap.getOrDefault(accountNumber, new ArrayList<>());
    }

    public void printTransactionHistory() {
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getTransactionDetails());
        }
    }
}

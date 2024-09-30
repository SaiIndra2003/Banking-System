package com.banking.bank;

import com.banking.account.Account;
import com.banking.account.CurrentAccount;
import com.banking.account.SavingsAccount;
import com.banking.manager.TransactionManager;
import com.banking.report.BalanceReport;
import com.banking.report.HistoryReport;
import com.banking.report.Report;
import com.banking.transaction.DepositTransaction;
import com.banking.transaction.Transaction;
import com.banking.transaction.WithdrawTransaction;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Account> bankAccounts;
    private final TransactionManager transactionManager;

    public Bank() {
        bankAccounts = new ArrayList<>();
        transactionManager = new TransactionManager();
    }

    public void createSavingsAccount(String accountNumber, int interest) {
        Account newSavingsAccount = new SavingsAccount(accountNumber, interest);
        bankAccounts.add(newSavingsAccount);
    }

    public void createCurrentAccount(String accountNumber, int overDue) {
        Account newCurrentAccount = new CurrentAccount(accountNumber, overDue);
        bankAccounts.add(newCurrentAccount);
    }

    public Account getAccount(String accountNumber) {
        for (Account account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        Account bankAccount = getAccount(accountNumber);
        if (bankAccount != null) {
            Transaction transaction = new DepositTransaction(bankAccount, amount);
            transactionManager.executeTransaction(bankAccount, transaction);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            Transaction transaction = new WithdrawTransaction(account, amount);
            transactionManager.executeTransaction(account, transaction);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void generateBalanceReport(String accountNumber) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            Report report = new BalanceReport();
            report.generate(account);
        } else {
            System.out.println("Account not found !");
        }
    }

    public void printTransactionHistory() {
        transactionManager.printTransactionHistory();
    }

    public void generateTransactionHistoryReport(String accountNumber) {
        Account account = getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        Report report = new HistoryReport(transactionManager);
        report.generate(account);

    }
}

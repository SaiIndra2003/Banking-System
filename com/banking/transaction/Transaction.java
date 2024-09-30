package com.banking.transaction;

public interface Transaction {
    String getTransactionDetails();

    boolean execute();
}

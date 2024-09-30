package com.banking.report;

import com.banking.account.Account;

public interface Report {
    void generate(Account account);
}

package org.academiadecodigo.javabank.command;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;

public class AccountConverter {

    AccountService accountService;

    public Account createAccount(AccountDto accountDto) {
        Account a1 = accountService.findById(accountDto.getId());

        a1.setBalance(accountDto.getBalance());
        a1.setId(accountDto.getId());

        return a1;
    }
}

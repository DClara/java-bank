package org.academiadecodigo.javabank.domain.operation;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.managers.AccountManager;

public interface Operation {
    void execute(Customer customer);
}

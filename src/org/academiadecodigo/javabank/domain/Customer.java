package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private static int counter;
    private int customerId = 0;
    private AccountManager accountManager;
    private Map<Integer, Account> accounts = new HashMap<>();

    public Customer() {
        this.customerId = ++counter;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public AccountManager getAccountManager() {
        return this.accountManager;
    }

    public int openAccount(AccountType accountType) {
        Account account = accountManager.openAccount(accountType);
        accounts.put(account.getId(), account);
        return account.getId();
    }

    public double getBalance(int id) {
        return accounts.get(id).getBalance();
    }

    public double getBalance() {

        double balance = 0;

        for (Account account : accounts.values()) {
            balance += account.getBalance();
        }

        return balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Account getAccount() {
        return accountManager.getActiveAccount();
    }
}

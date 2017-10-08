package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashSet;
import java.util.Set;

public class Bank {

    private AccountManager accountManager;
    private Set<Customer> customers = new HashSet<>();
    private Customer activeCustomer;

    public Bank(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        setActiveCustomer(customer);
        customer.setAccountManager(accountManager);
    }

    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers) {
            balance += customer.getBalance();
        }

        return balance;
    }

    public int activeAccountId() {
        return accountManager.getActiveAccountID();
    }

    public void setActiveCustomer(Customer customer) {
        this.activeCustomer = customer;
    }

    public Customer getActiveCustomer() {
        return this.activeCustomer;
    }

}

package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.AccountService;

import java.util.HashMap;
import java.util.Set;

public class CustomerService {

    private HashMap<Integer, Customer> customers;

    private int loginCustomer;

    public CustomerService() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public void addAccount(Account account) {
        customers.get(loginCustomer).getAccounts().put(account.getId(),account);
    }

    public Set<Integer> getCustomerIds() {
        return customers.keySet();
    }

    public Customer getLoginCustomer() {
        return customers.get(loginCustomer);
    }

    public void setLoginCustomer(int id) {
        this.loginCustomer = id;
    }
}

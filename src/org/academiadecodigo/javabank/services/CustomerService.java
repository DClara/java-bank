package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.AccountService;

import java.util.HashMap;
import java.util.Set;

public class CustomerService {

    private HashMap<Integer, Customer> customers;
    private AuthenticationService authenticationService;

    public CustomerService() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public void addAccount(Account account) {
        customers.get(authenticationService.getLoginCustomer()).getAccounts().put(account.getId(), account);
    }

    public Customer getLoginCustomer(){
        return authenticationService.getLoginCustomer();
    }

    public Set<Integer> getCustomerIds() {
        return customers.keySet();
    }

    public HashMap<Integer, Customer> getCustomers() {
        return customers;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}



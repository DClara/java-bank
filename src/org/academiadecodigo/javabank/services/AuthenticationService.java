package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

public class AuthenticationService {
    private CustomerService customerService;
    private int loginCustomer;

    public Customer getLoginCustomer() {
        return customerService.getCustomers().get(this.loginCustomer);
    }

    public void setLoginCustomer(int id) {
        this.loginCustomer = id;
    }

    public boolean authenticate (int id) {
        return customerService.getCustomerIds().contains(id);
    }

    public void setCustomerService (CustomerService customerService) {
        this.customerService = customerService;
    }
}

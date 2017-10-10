package org.academiadecodigo.javabank.services;

public class AuthenticationService {
    private CustomerService customerService;

    public boolean authenticate (int id) {
        return customerService.getCustomerIds().contains(id);
    }

    public void setCustomerService (CustomerService customerService) {
        this.customerService = customerService;
    }
}

package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AuthServiceMock;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.services.CustomerServiceMock;

public class AuthServiceTest {

    public boolean test() {

        AuthServiceMock authService = new AuthServiceMock();
        CustomerService customerService = new CustomerServiceMock();
        authService.setCustomerService(customerService);

        Customer customer = new Customer();
        customerService.add(customer);

        // should authenticate
        authService.authenticate(customer.getId());
        if (authService.getAccessingCustomer() != customer) {
            return false;
        }

        return true;
    }
}

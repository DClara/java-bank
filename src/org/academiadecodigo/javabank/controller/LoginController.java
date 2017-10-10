package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AuthenticationService;
import org.academiadecodigo.javabank.services.CustomerService;

public class LoginController extends AbstractController {

    private Controller nextController;

    private CustomerService customerService;
    private AuthenticationService authenticationService;

    public void onLogin(int id) {
        if (!authenticationService.authenticate(id)) {
            this.init();
            return;
        }
        customerService.setLoginCustomer(id);
        nextController.init();
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}

package org.academiadecodigo.javabank.controller.transaction;

import org.academiadecodigo.javabank.controller.AbstractController;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    //protected CustomerService customerService;
    protected AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

}

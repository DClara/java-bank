package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.views.View;

public class DepositController implements Controller {

    private Bank bank;
    private Customer customer;
    private View view;
    private Controller nextController;

    public DepositController(Bank bank) {
        this.bank = bank;
        this.customer = bank.getCustomer(bank.getAccessingCustomerId());
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void scanAccount (int id, double amount) {
        AccountManager accountManager = bank.getAccountManager();
            accountManager.deposit(id,amount);
        nextController.init();
    }

    @Override
    public void init() {
        this.view.show();
    }
}

package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.views.View;

import java.text.DecimalFormat;
import java.util.Set;

public class ViewBalanceController implements Controller {
    private View view;
    private Bank bank;
    private Controller nextController;
    Set<Account> accounts;

    DecimalFormat df = new DecimalFormat("#.##");

    public ViewBalanceController(Bank bank) {
        this.bank = bank;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init() {
        this.view.show();
    }

    public void scanCustomerAccounts() {

        System.out.println("\n" + bank.getCustomer(bank.getAccessingCustomerId()).getName() + Messages.BALANCE_MESSAGE + "\n");

        accounts = bank.getCustomer(bank.getAccessingCustomerId()).getAccounts();

        for (Account account: accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }
        nextController.init();
    }

}

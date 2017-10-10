package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controller.ViewBalanceController;
import org.academiadecodigo.javabank.domain.Bank;

public class BalanceView implements View {

    private Bank bank;
    private ViewBalanceController viewBalanceController;
    private Prompt prompt;

    public BalanceView(Bank bank) {
        this.bank = bank;
        this.prompt = new Prompt(System.in,System.out);
    }

    public void setViewBalanceController(ViewBalanceController viewBalanceController) {
        this.viewBalanceController = viewBalanceController;
    }

    @Override
    public void show() {
        viewBalanceController.scanCustomerAccounts();
    }

}

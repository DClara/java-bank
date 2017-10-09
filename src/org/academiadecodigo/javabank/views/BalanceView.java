package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.ViewBalanceController;
import org.academiadecodigo.javabank.domain.Customer;

public class BalanceView implements View {

    private Customer customer;
    private ViewBalanceController viewBalanceController;
    private Prompt prompt;

    public BalanceView(Customer customer) {
        this.customer = customer;
        this.prompt = new Prompt(System.in,System.out);
    }

    public void setViewBalanceController(ViewBalanceController viewBalanceController) {
        this.viewBalanceController = viewBalanceController;
    }

    @Override
    public void show() {

    }
}

package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.views.View;

public class ViewBalanceController implements Controller {
    private View view;
    private Customer customer;
    private Controller nextController;

    public ViewBalanceController(Customer customer, View view) {
        this.customer = customer;
        this.view = view;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    @Override
    public void init() {
        this.view.show();
    }
}

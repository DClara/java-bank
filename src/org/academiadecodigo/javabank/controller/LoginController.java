package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.views.View;

public class LoginController implements Controller {

    private Bank bank;
    private View view;
    private Controller nextController;

    public LoginController(Bank bank, View view) {
        this.bank = bank;
        this.view = view;
    }

    @Override
    public void init() {
        this.view.show();
    }

    public void setNextController(Controller controller) {
        this.nextController = controller;
    }

    public void setAccessingId(int id) {
        bank.setAccessingCustomerId(id);
        nextController.init();
    }
}

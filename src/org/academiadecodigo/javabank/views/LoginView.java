package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.domain.Bank;

public class LoginView implements View {

    private Prompt prompt;
    private Bank bank;
    private LoginController loginController;

    public LoginView(Bank bank) {
        this.prompt = new Prompt(System.in, System.out);
        this.bank = bank;
    }

    public int scanCustomerId() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomerIds());
        scanner.setMessage(Messages.CHOOSE_CUSTOMER);
        scanner.setError(Messages.ERROR_INVALID_CUSTOMER);
        return prompt.getUserInput(scanner);

    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void show() {
        int customerId = scanCustomerId();
        loginController.setAccessingId(customerId);
    }
}

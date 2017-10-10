package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.controller.DepositController;
import org.academiadecodigo.javabank.domain.Bank;

public class DepositView implements View {

    private Bank bank;
    private DepositController depositController;
    private Prompt prompt;

    public DepositView (Bank bank) {
        this.bank = bank;
        this.prompt = new Prompt(System.in,System.out);
    }

    public void setDepositController(DepositController depositController) {
        this.depositController = depositController;
    }

    public int scanAccountId() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(bank.getCustomer(bank.getAccessingCustomerId()).getAccountIds());
        scanner.setMessage(Messages.CHOOSE_ACCOUNT);
        scanner.setError(Messages.ERROR_INVALID_ACCOUNT);
        return prompt.getUserInput(scanner);
    }

    public double scanAmount() {

        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Messages.CHOOSE_AMOUNT);
        scanner.setError(Messages.ERROR_INVALID_AMOUNT);
        return prompt.getUserInput(scanner);
    }

    @Override
    public void show() {
        int accountId = scanAccountId();
        double amount = scanAmount();
        depositController.scanAccount(accountId, amount);
    }
}

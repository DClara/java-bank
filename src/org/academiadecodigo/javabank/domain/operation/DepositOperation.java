package org.academiadecodigo.javabank.domain.operation;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.domain.Customer;

public class DepositOperation implements Operation {

    @Override
    public void execute(Customer customer) {
        Prompt accountId = new Prompt(System.in, System.out);

        DoubleInputScanner amountScanner = new DoubleInputScanner();
        amountScanner.setMessage("Insert Amount to deposit: ");

        double userSelection = accountId.getUserInput(amountScanner);

        customer.getAccountManager().deposit(customer.getAccount().getId(),userSelection);
        return;
    }
}

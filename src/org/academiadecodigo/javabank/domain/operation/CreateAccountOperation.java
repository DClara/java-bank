package org.academiadecodigo.javabank.domain.operation;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.javabank.domain.account.AccountType;

public class CreateAccountOperation implements Operation {

    @Override
    public void execute() {

        Prompt accountId = new Prompt(System.in, System.out);

        IntegerInputScanner customerScanner = new IntegerInputScanner();
        customerScanner.setMessage("Insert Account ID: ");

        int userSelection = accountId.getUserInput(customerScanner);

    }
}

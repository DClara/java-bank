package org.academiadecodigo.javabank.domain.operation;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.domain.user_application_test.EntryMenu;

public class CreateAccountOperation implements Operation {

    @Override
    public void execute(Customer customer) {
        /*
        Prompt accountId = new Prompt(System.in, System.out);

        IntegerInputScanner customerScanner = new IntegerInputScanner();
        customerScanner.setMessage("Insert Account ID: ");

        int userSelection = accountId.getUserInput(customerScanner);*/

        int accountID = customer.openAccount(AccountType.CHECKING);
        System.out.println("Account with ID " + accountID + " was successfully created");
    }
}

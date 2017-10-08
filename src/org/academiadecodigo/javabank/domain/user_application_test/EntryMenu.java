package org.academiadecodigo.javabank.domain.user_application_test;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.operation.CreateAccountOperation;
import org.academiadecodigo.javabank.domain.operation.DepositOperation;
import org.academiadecodigo.javabank.domain.operation.Operation;
import org.academiadecodigo.javabank.domain.operation.WithdrawOperation;

import java.util.HashMap;
import java.util.Map;

public class EntryMenu {

    private Customer customer;
    private Map<Integer, Operation> operationAssociation = new HashMap();

    public EntryMenu(Customer customer) {
        this.customer = customer;
        this.defineOperation();
    }

    public void menuPresentation() {
        // Define some options for the menu
        String[] menuOptions = {"Create Account", "Deposit", "Withdraw", "Exit"};

        // Create a new prompt attached to standard input/output
        Prompt menuOption = new Prompt(System.in, System.out);

        // Instantiate a menu scanner
        MenuInputScanner menuScanner = new MenuInputScanner(menuOptions);

        // Setup the menu prompt message
        menuScanner.setMessage("Welcome, customer " + customer.getCustomerId() + ". Choose an option: ");

        // Grab the user in a loop until a valid input is inserted
        int menuSelection = menuOption.getUserInput(menuScanner);

        this.operationAssociation.get(menuSelection).execute(customer);

    }


    public void defineOperation() {
        operationAssociation.put(1, new CreateAccountOperation());
        operationAssociation.put(2, new DepositOperation());
        operationAssociation.put(3, new WithdrawOperation());

    }
}


package org.academiadecodigo.javabank.domain.user_application_test;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.TestPopulation;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Application {

    public static void main(String[] args) {

        Application application = new Application();
        application.start();
    }

    private void start() {
        Bank bank = new Bank(new AccountManager());

        TestPopulation testPopulation = new TestPopulation();
        testPopulation.populate4test(bank);

        EntryMenu entryMenu = new EntryMenu();
        entryMenu.menuPresentation();
    }


    private int scanCustomerId() {


        return 1;
    }
}

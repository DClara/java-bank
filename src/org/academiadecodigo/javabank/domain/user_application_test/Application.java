package org.academiadecodigo.javabank.domain.user_application_test;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.TestPopulation;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Application {
    Bank bank;

    public static void main(String[] args) {

        Application application = new Application();
        application.start();
        application.showMenu();
    }

    private void start() {
        bank = new Bank(new AccountManager());

        TestPopulation testPopulation = new TestPopulation();
        testPopulation.populate4test(bank);
    }

    private void showMenu() {
        Customer customer = scanActiveCustomer(this.bank);
        EntryMenu entryMenu = new EntryMenu(customer);
        entryMenu.menuPresentation();
    }

    private int scanAccountId() {
        return this.bank.activeAccountId();
    }

    private Customer scanActiveCustomer(Bank bank) {
        return bank.getActiveCustomer();
    }
}

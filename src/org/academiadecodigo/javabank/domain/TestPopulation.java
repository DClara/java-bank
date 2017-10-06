package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.managers.AccountManager;

public class TestPopulation {

    public void populate4test(Bank bank) {
        Customer c1 = new Customer();
        bank.addCustomer(c1);

    }
}

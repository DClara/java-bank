package org.academiadecodigo.javabank.test;

public class Test {

    public static void main(String[] args) {

        AccountTest accountTest = new AccountTest();
        CustomerTest customerTest = new CustomerTest();
        BankTest bankTest = new BankTest();

        System.out.println("Account: " + (accountTest.test() ? "OK" : "FAIL"));
        System.out.println("Customer: " + (customerTest.test() ? "OK" : "FAIL"));
        System.out.println("Bank: " + (bankTest.test() ? "OK" : "FAIL"));

    }


}

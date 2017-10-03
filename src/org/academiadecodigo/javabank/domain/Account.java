package org.academiadecodigo.javabank.domain;

public class Account {

    private AccountType accountType;
    private double balance = 0;
    private int id;

    public Account(int id, AccountType accountType) {
        this.id = id;
        this.accountType = accountType;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getId() {
        return id;
    }
}

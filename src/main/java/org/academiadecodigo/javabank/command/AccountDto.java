package org.academiadecodigo.javabank.command;

import org.academiadecodigo.javabank.model.account.Account;

public class AccountDto {

    private Integer id;
    private Integer version;
    private double balance;


    public AccountDto(){}

    public AccountDto(Account account) {
        this.id = account.getId();
        this.balance = account.getBalance();
    }

    public Integer getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}

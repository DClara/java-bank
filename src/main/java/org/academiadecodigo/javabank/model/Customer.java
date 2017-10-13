package org.academiadecodigo.javabank.model;

import org.academiadecodigo.javabank.model.account.Account;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AbstractModel {

    private String name;

    @OneToMany(
    // propagate changes on customer entity to account entities
    cascade = {CascadeType.ALL},
    // make sure to remove accounts if unlinked from customer
    orphanRemoval = true,
    // use customer foreign key on account table to establish
    // the many-to-one relationship instead of a join table
    mappedBy = "customer",
    // fetch accounts from database together with user
    fetch = FetchType.EAGER
    )
    private List<Account> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

}


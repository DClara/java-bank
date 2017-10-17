package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;

public class JpaAccountDao extends JpaGenericDao<Account> implements AccountDao {

    public JpaAccountDao(JpaSessionManager sm) {
        super(sm, Account.class);
    }

}

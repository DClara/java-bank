package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.exception.TransactionException;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.services.CustomerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao dao;
    private TransactionManager tm;

    public CustomerServiceImpl(CustomerDao dao, TransactionManager tm) {

        this.dao = dao;
        this.tm = tm;

    }

    @Override
    public double getBalance(Integer id) {

        double balance = 0;

        try {

            tm.beginRead();
            Customer customer = dao.findById(id);

            if (customer == null) {
                tm.rollback();
                throw new IllegalArgumentException("Customer does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            for (Account account : accounts) {
                balance += account.getBalance();
            }

            tm.commit();


        } catch (TransactionException ex) {

            tm.rollback();

        }

        return balance;
    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {

        Set<Integer> accountIds = new HashSet<>();

        try {

            tm.beginRead();
            Customer customer = dao.findById(id);

            if (customer == null) {
                tm.rollback();
                throw new IllegalArgumentException("Customer does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            for (Account account : accounts) {
                accountIds.add(account.getId());
            }

            tm.commit();


        } catch (TransactionException ex) {

            tm.rollback();
        }

        return accountIds;

    }

}

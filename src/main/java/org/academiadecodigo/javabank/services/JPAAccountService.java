package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import java.util.Collections;

public class JPAAccountService implements AccountService {

    private EntityManagerFactory emf;

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void add(Account account) {
        if (account.getId() == null) {

        }

        saveOrUpdate(account);
    }

    @Override
    public void deposit(int id, double amount) {

    }

    @Override
    public void withdraw(int id, double amount) {

    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

    }


    public Account saveOrUpdate(Account account) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            Account savedAccount = em.merge(account);
            em.getTransaction().commit(); // close transaction
            return savedAccount;

        } catch (RollbackException ex) {

            em.getTransaction().rollback(); // something went wrong, make sure db is consistent
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}

package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JPACustomerService implements CustomerService {


    private EntityManagerFactory emf;

    public JPACustomerService (EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void add(Customer customer) {

        if (customer.getId() == null) {

            customer.setId(getNextId());
        }

        // customerMap.put(customer.getId(), customer);
        saveOrUpdate(customer);
    }

    @Override
    public Customer findById(Integer id) {
        // open a new connection to the database
        EntityManager em = emf.createEntityManager();

        try {

            // fetch a new customer by using its id
            return em.find(Customer.class, id);

        } finally {

            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Customer> findAll() {
        EntityManager em = emf.createEntityManager();

        try {

            // fetch a new customer by using its id
            return em.createQuery("from Customer", Customer.class).getResultList();

        } finally {

            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Set<Integer> getCustomerIds() {

        EntityManager em = emf.createEntityManager();
        Set<Integer> result = new HashSet<>();

        try {

            // fetch all customer ids
            List<Integer> aux = em.createQuery("select id from Customer", Integer.class).getResultList();
            for (Integer integer : aux) {
                result.add(integer);
            }
            return result;

        } finally {

            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public double getBalance(int customerId) {

        EntityManager em = emf.createEntityManager();
        List<Account> accounts;
        double balance = 0;

        try {
            accounts = em.createQuery("from Account where customer.id = :customerId", Account.class).setParameter("customerId", customerId).getResultList();

            for (Account account : accounts) {
                balance += account.getBalance();
            }

            return balance;

        } finally {

            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public Set<Integer> getCustomerAccountNumbers(Integer id) {

        EntityManager em = emf.createEntityManager();
        Set<Integer> accountIds = new HashSet<>();

        try {
            List<Integer> aux = em.createQuery("select id from Account where customer.id = :id", Integer.class).setParameter("id", id).getResultList();

            for (Integer integer : aux) {
                accountIds.add(integer);
            }
            return accountIds;

        } finally {

            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    private Integer getNextId() {

        int maxId = Collections.max(getCustomerIds());
        return ++maxId;
    }

    public Customer saveOrUpdate(Customer customer) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            Customer savedCustomer = em.merge(customer);
            em.getTransaction().commit(); // close transaction
            return savedCustomer;

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




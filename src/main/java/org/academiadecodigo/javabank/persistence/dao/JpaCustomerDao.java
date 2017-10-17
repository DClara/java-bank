package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;

import javax.persistence.EntityManagerFactory;
import java.util.Set;

public class JpaCustomerDao extends JpaGenericDao<Customer> implements CustomerDao {

    public JpaCustomerDao(JpaSessionManager sm) {
        super(sm, Customer.class);
    }

    @Override
    public Set<Integer> getCustomerAccountIds(Integer id) {
        return null;
    }

}

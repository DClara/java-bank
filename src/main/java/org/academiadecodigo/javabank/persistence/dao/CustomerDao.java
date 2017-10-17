package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.Customer;

import java.util.Set;

public interface CustomerDao extends Dao<Customer> {

    Set<Integer> getCustomerAccountIds(Integer id);
}

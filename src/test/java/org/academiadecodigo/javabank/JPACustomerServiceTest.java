package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.JPACustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class JPACustomerServiceTest extends JPAPersistenceConfig {

    private JPACustomerService customerService;

    @Before
    public void populate() {
        customerService = new JPACustomerService(emf);
    }


    @Test
    public void successAdd() {
        Customer c1 = new Customer();
        c1.setName("Amilcar");
        customerService.add(c1);

        Customer toMatch = em.find(Customer.class, 4);

        Assert.assertEquals("Amilcar", toMatch.getName());

    }
    @Test
    public void successFindById() {
        Customer c1 = customerService.findById(1);

        Assert.assertEquals("Duarte", c1.getName());
    }

    @Test
    public void successFindAll(){
        List <Customer> list;
        list = customerService.findAll();

        Assert.assertEquals(3, list.size());
    }

    @Test
    public void successGetCustomerIds()  {
        Set<Integer> result;
        result = customerService.getCustomerIds();

        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void successGetBalance() {
        double balance;
        balance = customerService.getBalance(1);

        Assert.assertEquals(200.0, balance,0.1);
    }


    @Test
    public void getCustomerAccountNumbers() {
        Set<Integer> accountIds;
        accountIds = customerService.getCustomerAccountNumbers(1);

        Assert.assertNotNull(accountIds);
        Assert.assertEquals(2,accountIds.size());
        Assert.assertTrue(accountIds.contains(1));
    }
}

package org.academiadecodigo.javabank.persistence.jpa.dao;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaAccountDao;
import org.academiadecodigo.javabank.persistence.jpa.JpaIntegrationTestHelper;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Query;
import java.util.List;

import static org.junit.Assert.*;

public class JpaAccountDaoIntegrationTest extends JpaIntegrationTestHelper {

    private final static Integer INVALID_ID = 9999;
    private final static double DOUBLE_DELTA = 0.1;

    private JpaAccountDao accountDao;

    @Before
    public void setup() {

        accountDao = new JpaAccountDao(sm);

    }

    @Test
    public void testFindById() {

        // setup
        int id = 1;

        // exercise
        Account account = accountDao.findById(id);

        // verify
        assertNotNull("Account is null", account);
        assertEquals("Account id is wrong", id, account.getId().intValue());
        assertEquals("Account type is wrong", AccountType.CHECKING.toString(), account.getAccountType().toString());
        assertEquals("Account balance is wrong", 100, account.getBalance(), DOUBLE_DELTA);

    }

    @Test
    public void testFindByIdInvalid() {

        // exercise
        Account account = accountDao.findById(INVALID_ID);

        // verify
        assertNull("Account should be null", account);
    }

    @Test
    public void testFindAll() {

        // exercise
        List<Account> accounts = accountDao.findAll();

        // verify
        assertNotNull("Accounts are null", accounts);
        assertEquals("Number of accounts is wrong", 7, accounts.size());

    }

    @Test
    public void testFindAllFail() {

        // setup
        tx.beginWrite();
        Query query = sm.getCurrentSession().createQuery("delete from Account ");
        query.executeUpdate();
        query = sm.getCurrentSession().createQuery("delete from Customer");
        query.executeUpdate();
        tx.commit();

        // exercise
        List<Account> accounts = accountDao.findAll();

        // verify
        assertNotNull("Accounts are null", accounts);
        assertEquals("Number of accounts is wrong", 0, accounts.size());

    }

    @Test
    public void testAddAccount() {

        // setup
        Account newAccount = new CheckingAccount();

        // exercise
        tx.beginWrite();
        Account addedAccount = accountDao.saveOrUpdate(newAccount);
        tx.commit();

        // verify
        assertNotNull("Account not added", addedAccount);
        Account account = sm.getCurrentSession().find(Account.class, addedAccount.getId());
        assertNotNull("Account not found", account);

    }

    @Test
    public void testUpdateAccount() {

        // setup
        int id = 1;
        Account account = sm.getCurrentSession().find(Account.class, id);
        account.credit(100);

        // exercise
        tx.beginWrite();
        accountDao.saveOrUpdate(account);
        tx.commit();

        // verify
        account = sm.getCurrentSession().find(Account.class, id);
        assertEquals("Account balance is wrong", 200, account.getBalance(), DOUBLE_DELTA);

    }


    @Test
    public void testDeleteAccountOwned() {

        // setup
        int id = 1;

        // exercise
        tx.beginWrite();
        accountDao.delete(id);
        tx.commit();

        // verify
        Account account = sm.getCurrentSession().find(Account.class, id);
        assertNotNull("Account owned by customer should not be deleted", account);
    }

    @Test
    public void testDeleteOrphanAccount() {

        // setup
        int id = 7;

        // exercise
        tx.beginWrite();
        accountDao.delete(id);
        tx.commit();

        // verify
        Account account = sm.getCurrentSession().find(Account.class, id);
        assertNull("Account is not null", account);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteInvalid() {

        // exercise
        tx.beginWrite();
        accountDao.delete(INVALID_ID);
        tx.commit();
    }

}

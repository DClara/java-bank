package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.exception.TransactionException;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.academiadecodigo.javabank.services.AccountService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class AccountServiceImpl implements AccountService {

    private AccountDao dao;
    private TransactionManager tm;

    public AccountServiceImpl(AccountDao dao, TransactionManager tm) {
        this.dao = dao;
        this.tm = tm;
    }

    @Override
    public int add(Account account) {

        try {

            tm.beginWrite();
            Account toUpdate = dao.saveOrUpdate(account);
            tm.commit();
            return toUpdate.getId();

        } catch (TransactionException ex) {

            tm.rollback();

        }
        return 0;
    }

    @Override
    public void deposit(Integer id, double amount) {

        try {
            tm.beginWrite();
            Account toCredit = dao.findById(id);

            if (toCredit == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid account id");
            }

            toCredit.credit(amount);
            dao.saveOrUpdate(toCredit);
            tm.commit();

        } catch (TransactionException ex) {

            tm.rollback();

        }

    }

    @Override
    public void withdraw(Integer id, double amount) {

        try {
            tm.beginWrite();
            Account toCredit = dao.findById(id);

            if (toCredit == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid account id");
            }

            toCredit.debit(amount);
            dao.saveOrUpdate(toCredit);
            tm.commit();

        } catch (TransactionException ex) {

            tm.rollback();

        }
    }

    @Override
    public void transfer(Integer srcId, Integer dstId, double amount) {


        try {

            tm.beginWrite();
            Account toDebit = dao.findById(srcId);
            Account toCredit = dao.findById(dstId);

            if (toDebit == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid src account id");
            }

            if (toCredit == null) {
                tm.rollback();
                throw new IllegalArgumentException("invalid dst account id");
            }

            toDebit.debit(amount);
            toCredit.credit(amount);

            dao.saveOrUpdate(toDebit);
            dao.saveOrUpdate(toCredit);

            tm.commit();

        } catch (TransactionException ex) {

            tm.rollback();

        }

    }

}

package org.academiadecodigo.javabank.persistence.jpa;

import org.academiadecodigo.javabank.persistence.TransactionManager;

public class JpaTransactionManager implements TransactionManager {

    private JpaSessionManager sessionManager;

    public JpaTransactionManager() {
    };

    public void beginRead() {
       sessionManager.startSession();
    }

    public void beginWrite() {
        sessionManager.getCurrentSession().getTransaction().begin();
    }

    public void commit() {

        if (sessionManager.getCurrentSession().getTransaction().isActive()) {
            sessionManager.getCurrentSession().getTransaction().commit();
        }

        sessionManager.stopSession();
    }

    public void rollback() {

        if (sessionManager.getCurrentSession().getTransaction().isActive()) {
            sessionManager.getCurrentSession().getTransaction().rollback();
        }

        sessionManager.stopSession();
    }


    public void setSessionManager(JpaSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public JpaSessionManager getSessionManager() {
        return sessionManager;
    }
}

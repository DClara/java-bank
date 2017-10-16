package org.academiadecodigo.javabank.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class SessionManager {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public SessionManager (EntityManagerFactory emf) {
        this.emf = emf;
    }

    public abstract void startSession();

    public abstract void stopSession();

    public abstract EntityManager getCurrentSession();

    public void setEm(EntityManager em) {
        this.em = em;
    }
}


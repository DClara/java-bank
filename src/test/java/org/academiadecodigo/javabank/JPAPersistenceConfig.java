package org.academiadecodigo.javabank;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JPAPersistenceConfig {
    protected EntityManagerFactory emf;
    protected EntityManager em;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT);
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.clear();
        em.close();
        emf.close();

    }
}

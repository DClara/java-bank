package org.academiadecodigo.javabank.persistence;


import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;

// allows services to use common semantics for read/write operations
public abstract class TransactionManager {

    protected JpaSessionManager sm;

    public TransactionManager (JpaSessionManager sm) {
        this.sm = sm;
    }

    public abstract void beginRead();

    public abstract void beginWrite();

    public abstract void commit();

    public abstract void rollback();
}
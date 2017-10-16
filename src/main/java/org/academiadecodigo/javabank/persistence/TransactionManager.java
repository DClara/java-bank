package org.academiadecodigo.javabank.persistence;


// allows services to use common semantics for read/write operations
public abstract class TransactionManager {

    protected SessionManager sm;

    public TransactionManager (SessionManager sm) {
        this.sm = sm;
    }

    public abstract void beginRead();

    public abstract void beginWrite();

    public abstract void commit();

    public abstract void rollback();
}
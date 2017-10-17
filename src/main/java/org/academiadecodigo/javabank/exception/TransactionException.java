package org.academiadecodigo.javabank.exception;

import javax.persistence.RollbackException;

public class TransactionException extends RuntimeException {

    public TransactionException() {
        super();
    }

    public TransactionException(String message) {
        super(message);
    }
}


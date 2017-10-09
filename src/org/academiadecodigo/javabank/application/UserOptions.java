package org.academiadecodigo.javabank.application;

import org.academiadecodigo.javabank.application.operations.Operation;

import java.util.HashMap;
import java.util.Map;

public enum  UserOptions {

    GET_BALANCE(1, Messages.MENU_GET_BALANCE),
    DEPOSIT(2, Messages.MENU_DEPOSIT),
    WITHDRAW(3, Messages.MENU_WITHDRAW),
    OPEN_ACCOUNT(4, Messages.MENU_OPEN_ACCOUNT),
    QUIT(5, Messages.MENU_QUIT);

    private int option;
    private String message;
    private Map<Integer, Operation> map = new HashMap<>();

    public int getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }

    UserOptions(int option, String message) {
       this.option = option;
       this.message = message;
    }

    public static String[] getMessages() {

        String[] messages = new String[values().length];

        for (UserOptions option: values()) {
            messages[option.getOption() - 1] = option.getMessage();
        }

        return messages;
    }

}

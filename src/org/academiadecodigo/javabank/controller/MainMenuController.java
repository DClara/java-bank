package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.views.View;

import java.util.Map;

public class MainMenuController implements Controller {

    private Bank bank;
    private View view;
    private Controller nextController;
    private Map<Integer, Controller> controllersMap;

    public MainMenuController(Bank bank, View view) {
        this.bank = bank;
        this.view = view;
    }

    @Override
    public void init() {
        this.view.show();
    }

    public void setNextController(Controller controller) {
        this.nextController = nextController;
    }

    public void setControllersMap(Map<Integer, Controller> controllersMap) {
        this.controllersMap = controllersMap;
    }

    public void onUserSelection(int option) {
        if (option == UserOptions.QUIT.getOption()) {
            return;
        }
        controllersMap.get(option).init();
    }



}

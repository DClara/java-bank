package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.views.BalanceView;
import org.academiadecodigo.javabank.views.LoginView;
import org.academiadecodigo.javabank.views.MainMenuView;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {
    private Controller initialController;


    public void populate4test() {
        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);



        Customer c1 = new Customer(1,"Rui");
        Customer c2 = new Customer(2,"Sergio");
        Customer c3 = new Customer(3,"Bruno");
        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);

        LoginView loginView = new LoginView(bank);
        LoginController loginController = new LoginController(bank, loginView);
        //loginController.setNextView();

        setInitialController(loginController);
        loginView.setLoginController(loginController);

        MainMenuView mainMenuView = new MainMenuView(bank);
        MainMenuController mainMenuController = new MainMenuController(bank, mainMenuView);
        loginController.setNextController(mainMenuController);
        mainMenuView.setMainMenuController(mainMenuController);

        mainMenuController.setControllersMap(buildControllersMap());

        Customer activeCustomer = bank.getCustomer(bank.getAccessingCustomerId());
        BalanceView balanceView = new BalanceView(activeCustomer);
        ViewBalanceController viewBalanceController = new ViewBalanceController(activeCustomer, balanceView);

        balanceView.setViewBalanceController(viewBalanceController);

    }

    public Controller getInitialController() {
        return initialController;
    }

    public void setInitialController(Controller initialController) {
        this.initialController = initialController;
    }



    private Map<Integer, Controller> buildControllersMap() {

        Map<Integer, Controller> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new ViewBalanceController());
        map.put(UserOptions.DEPOSIT.getOption(), new DepositController());
        map.put(UserOptions.WITHDRAW.getOption(), new WithdrawController());
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new OpenAccountController());

        return map;

    }
}

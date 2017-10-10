package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.transaction.DepositController;
import org.academiadecodigo.javabank.controller.transaction.WithdrawalController;
import org.academiadecodigo.javabank.services.AuthenticationService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.view.UserOptions;
import org.academiadecodigo.javabank.controller.*;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.view.*;
import org.academiadecodigo.javabank.view.AccountTransactionView;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {
    private CustomerService customerService = new CustomerService();
    private AccountService accountService = new AccountService();
    private AuthenticationService authenticationService = new AuthenticationService();

    public CustomerService generateTestData() {


        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");
        customerService.addCustomer(c1);
        customerService.addCustomer(c2);
        customerService.addCustomer(c3);


        return customerService;
    }

    public LoginController wireObjects() {

        // attach all input to standard i/o
        Prompt prompt = new Prompt(System.in, System.out);

        authenticationService.setCustomerService(customerService);
        customerService.setAuthenticationService(authenticationService);

        // wire login controller and view
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();
        loginController.setView(loginView);
        loginController.setCustomerService(customerService);
        loginController.setAuthenticationService(authenticationService);
        loginController.setCustomerService(customerService);
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);

        // wire main controller and view
        MainController mainController = new MainController();
        MainView mainView = new MainView();
        mainController.setCustomerService(customerService);
        mainView.setPrompt(prompt);
        mainView.setMainController(mainController);
        mainController.setView(mainView);
        loginController.setNextController(mainController);

        // wire balance controller and view
        BalanceController balanceController = new BalanceController();
        BalanceView balanceView = new BalanceView();
        balanceView.setBalanceController(balanceController);
        balanceController.setView(balanceView);
        balanceController.setCustomerService(customerService);

        // wire new account controller and view
        NewAccountView newAccountView = new NewAccountView();
        NewAccountController newAccountController = new NewAccountController();
        newAccountController.setCustomerService(customerService);
        newAccountController.setView(newAccountView);
        newAccountView.setNewAccountController(newAccountController);
        newAccountController.setAccountService(accountService);

        // wire account transactions controllers and views
        DepositController depositController = new DepositController();
        WithdrawalController withdrawalController = new WithdrawalController();
        AccountTransactionView depositView = new AccountTransactionView();
        AccountTransactionView withdrawView = new AccountTransactionView();
        depositController.setAccountService(accountService);
        depositController.setView(depositView);
        withdrawalController.setAccountService(accountService);
        withdrawalController.setView(withdrawView);
        depositController.setCustomerService(customerService);
        depositView.setPrompt(prompt);
        depositView.setTransactionController(depositController);
        withdrawalController.setCustomerService(customerService);
        withdrawView.setPrompt(prompt);
        withdrawView.setTransactionController(withdrawalController);

        // setup the controller map
        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.GET_BALANCE.getOption(), balanceController);
        controllerMap.put(UserOptions.OPEN_ACCOUNT.getOption(), newAccountController);
        controllerMap.put(UserOptions.DEPOSIT.getOption(), depositController);
        controllerMap.put(UserOptions.WITHDRAW.getOption(), withdrawalController);

        mainController.setControllerMap(controllerMap);



        return loginController;
    }
}

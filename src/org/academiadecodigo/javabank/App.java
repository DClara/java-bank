package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;

public class App {


    public static void main(String[] args) {

        App app = new App();
        app.bootStrap();

    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();

        LoginController loginController = bootstrap.wireObjects();

        bootstrap.generateTestData();

        // start application
        loginController.init();

    }

}

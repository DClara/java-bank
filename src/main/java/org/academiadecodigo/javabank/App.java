package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.persistence.H2WebServer;
import org.academiadecodigo.javabank.persistence.SessionManager;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaAccountDao;
import org.academiadecodigo.javabank.persistence.dao.jpa.JpaCustomerDao;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.ldap.Control;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

            ApplicationContext context = new ClassPathXmlApplicationContext(("/spring/initXml.xml"));

            LoginController log = context.getBean("loginController", LoginController.class);
            log.init();




    }

    private void bootStrap(TransactionManager tx, JpaSessionManager sm) {

        /*AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(new JpaAccountDao(sm));
        accountService.setTx(tx);

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.setCustomerDao(new JpaCustomerDao(sm));
        customerService.setTx(tx);

        Bootstrap bootstrap = new Bootstrap();

        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(accountService);
        bootstrap.setCustomerService(customerService);

        Controller controller = bootstrap.wireObjects();*/

        // start application
        return;
    }
}

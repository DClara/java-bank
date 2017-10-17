package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.persistence.H2WebServer;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.persistence.dao.JpaAccountDao;
import org.academiadecodigo.javabank.persistence.dao.JpaCustomerDao;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.jpa.JpaTransactionManager;
import org.academiadecodigo.javabank.services.jpa.AccountServiceImpl;
import org.academiadecodigo.javabank.services.jpa.CustomerServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        try {


            H2WebServer h2WebServer = new H2WebServer();
            h2WebServer.start();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT);

            App app = new App();
            app.bootStrap(emf);

            emf.close();
            h2WebServer.stop();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void bootStrap(EntityManagerFactory emf) {

        Bootstrap bootstrap = new Bootstrap();

        JpaSessionManager sm = new JpaSessionManager(emf);
        TransactionManager tm = new JpaTransactionManager(sm);

        AccountDao accountDao = new JpaAccountDao(sm);
        CustomerDao customerDao = new JpaCustomerDao(sm);

        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new AccountServiceImpl(accountDao, tm));
        bootstrap.setCustomerService(new CustomerServiceImpl(customerDao, tm));

        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();

    }
}

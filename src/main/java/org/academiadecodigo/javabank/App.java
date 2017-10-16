package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.persistence.H2WebServer;
import org.academiadecodigo.javabank.services.AccountServiceMock;
import org.academiadecodigo.javabank.services.AuthServiceMock;
import org.academiadecodigo.javabank.services.JPACustomerService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {

        try {
            H2WebServer h2WebServer = new H2WebServer();
            h2WebServer.start();

            emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT);

            // EntityManager em = emf.createEntityManager();
            //em.find(Customer.class, 1);
            //em.close();

            App app = new App();
            app.bootStrap();

            emf.close();
            h2WebServer.stop();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setAuthService(new AuthServiceMock());
        bootstrap.setAccountService(new AccountServiceMock());
        bootstrap.setCustomerService(new JPACustomerService(emf));
        bootstrap.loadCustomers();

        LoginController loginController = bootstrap.wireObjects();

        // start application
        loginController.init();

    }
}

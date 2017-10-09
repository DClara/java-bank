package org.academiadecodigo.javabank;

public class App {

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.populate4test();

        bootstrap.getInitialController().init();
    }
}

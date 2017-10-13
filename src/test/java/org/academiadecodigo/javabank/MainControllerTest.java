package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.MainController;
import org.academiadecodigo.javabank.view.UserOptions;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MainControllerTest {

    private MainController mainController;
    private UserOptions userOption;
    private View view;


    @Before
    public void setup() {
        mainController = new MainController();
        view = mock(View.class);
        mainController.setView(view);
        userOption = mock((UserOptions.class));

        Controller c1 = mock(Controller.class);
        Controller c2 = mock(Controller.class);
    }



}

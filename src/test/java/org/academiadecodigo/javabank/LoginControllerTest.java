package org.academiadecodigo.javabank;


import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class LoginControllerTest {

    private LoginController loginController;
    private View view;

    @Before
    public void setup() {
        loginController = new LoginController();
        view = mock(View.class);
        loginController.setView(view);
    }

    @Test
    public void initTest() {
        loginController.init();
        verify(view).show();
    }

    @Test
    public void onLoginSuccess() {
        int fakeId = 973;

        Controller nextController = mock(Controller.class);
        loginController.setNextController(nextController);

        AuthService auth = mock(AuthService.class);
        loginController.setAuthService(auth);

        // if authenticate method is called with "rui" and "ferrao", the mock returns true
        when(auth.authenticate(fakeId)).thenReturn(true);
        loginController.onLogin(fakeId);

        // verify that authenticate method has been called with the correct arguments
        verify(nextController).init();
        verify(view, never()).show();
    }

    @Test
    public void onLoginFailure() {

        Controller nextController = mock(Controller.class);
        loginController.setNextController(nextController);
        AuthService auth = mock(AuthService.class);
        loginController.setAuthService(auth);
        when(auth.authenticate(anyInt())).thenReturn(false);

        loginController.onLogin(1);

        verify(nextController, never()).init();
        verify(view).show();

    }


}

package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.controller.MainMenuController;
import org.academiadecodigo.javabank.domain.Bank;

public class MainMenuView implements View {

    private Bank bank;
    private MainMenuController mainMenuController;
    private Prompt prompt;

    public MainMenuView (Bank bank) {
        this.prompt = new Prompt(System.in, System.out);
        this.bank = bank;
    }

    private MenuInputScanner buildMainMenu() {

        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);

        return mainMenu;
    }

    public int scanUserChoice() {

        MenuInputScanner mainMenu = buildMainMenu();
        return prompt.getUserInput(mainMenu);
    }

    @Override
    public void show() {
        mainMenuController.onUserSelection(scanUserChoice());
    }

    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
}

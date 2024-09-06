package org.example;

import org.example.controller.MainMenu;
import org.utils.UserInputException;

public class ClientServiceTest {
    public static void main(String[] args) throws UserInputException {



        MainMenu menu = new MainMenu();



        while(true) {
            menu.viewStartMenu();
        }
    }
}

package org.example.controller;

import org.example.model.Client;
import org.example.model.Role;
import org.example.service.AccountSevice;
import org.example.service.ClientService;
import org.utils.UserInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    ClientService clientService = new ClientService();
    AccountSevice accountSevice = new AccountSevice();
    Client client;
    public void viewStartMenu() throws UserInputException {
        System.out.println("--------------------------");
        System.out.println("МЕНЮ\n");
        System.out.println("1. Создать пользователя");
        System.out.println("2. Войти");

        System.out.println("\n3. Закончить\n");
        System.out.println("--------------------------");

        System.out.println("Выберите пункт\n");

        selectStartMenu();

    }

    public void selectStartMenu() throws UserInputException {
        switch (userInput()){
            case 1:
                clientService.registrationClient();
                break;
            case 2:
                client = clientService.loginClient();
//                client = clientService.loginClient();
                Role checkRole = client.getRole();
                if(checkRole == Role.ADMIN) {
                    System.out.println("-----\nADMIN PERMISSION\n----");
                    AdminMenu adminMenu = new AdminMenu(this);
                    adminMenu.viewAdminMenu();
                }
                else if(checkRole == Role.USER){
                    System.out.println("-----\nUSER PERMISSION\n----");
                    UserMenu userMenu = new UserMenu(this, client);
                    userMenu.viewUserMenu();
                }

                break;
            case 3:
                System.exit(1);
            default:
                System.out.println("ВЫ ВВЕЛИ ДРУГОЕ ЧИСЛО");
        }
    }

    public int userInput(){
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException i){
            throw new InputMismatchException("ВЫ ВВЕЛИ НЕ ТО");
        }

    }
}

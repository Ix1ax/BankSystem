package org.example.controller;

import org.utils.UserInputException;

public class AdminMenu {

    MainMenu menu;

    public AdminMenu(MainMenu menu){
        this.menu = menu;
    }

    public void viewAdminMenu() throws UserInputException {
        System.out.println("--------------------------");
        System.out.println("ADMIN MENU\n");
        System.out.println("1. Добавить нового админа");
        System.out.println("2. Посмотреть список клиентов");
        System.out.println("3. Посмотреть список аккаунтов");
        System.out.println("4. Назад");
        System.out.println("5. Выйти");
        System.out.println("--------------------------");

        System.out.println("Выберите пункт\n");

        selectAdminMenu();
    }

    public void selectAdminMenu() throws UserInputException {
        switch(menu.userInput()){
            case 1:
                menu.clientService.addAdmin();
                viewAdminMenu();
                break;
            case 2:
                menu.clientService.selectClients();
                viewAdminMenu();
                break;
            case 3:
                menu.accountSevice.selectAccounts();
                viewAdminMenu();
                break;
            case 4:
                menu.viewStartMenu();
                break;
            case 5:
                System.exit(1);
                break;

            default:
                System.out.println("ВЫ ВВЕЛИ ДРУГОЕ ЧИСЛО");
        }
    }
}

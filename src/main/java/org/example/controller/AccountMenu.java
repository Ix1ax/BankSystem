package org.example.controller;

import org.example.model.Account;
import org.example.model.Client;
import org.utils.UserInputException;

public class AccountMenu {
    Client client;
    Account account;
    MainMenu menu;
    UserMenu userMenu;

    public AccountMenu(MainMenu menu, Client client, Account account, UserMenu userMenu){
        this.menu = menu;
        this.client = client;
        this.account = account;
        this.userMenu = userMenu;
    }

    public void viewAccountMenu() throws UserInputException {
        System.out.println("--------------------------");
        System.out.println("ACCOUNT MENU\n");

        System.out.println("ВАШ ID: " + account.getAccountId() + "\n");

        System.out.println("1. Проверить баланс");
        System.out.println("2. Пополнить баланс");
        System.out.println("3. Перевести на другой аккаунт");
        System.out.println("4. Взять кредит");
        System.out.println("5. Посмотреть список транзакций");
        System.out.println("6. Посмотреть список кредитов");
        System.out.println("7. Назад");
        System.out.println("\n8. Закончить\n");
        System.out.println("--------------------------");

        System.out.println("Выберите пункт\n");

        selectAccountMenu();

    }

    public void selectAccountMenu() throws UserInputException {
        switch(menu.userInput()){
            case 1:
                viewAccountMenu();
                break;
            case 2:
                viewAccountMenu();
                break;
            case 3:
                viewAccountMenu();
                break;
            case 4:
                viewAccountMenu();
                break;
            case 5:
                viewAccountMenu();
                break;
            case 6:
                viewAccountMenu();
                break;
            case 7:
                userMenu.viewUserMenu();
                break;
            case 8:
                System.exit(1);
                break;
            default:
                System.out.println("ВЫ ВВЕЛИ ДРУГОЕ ЧИСЛО");
        }
    }

}

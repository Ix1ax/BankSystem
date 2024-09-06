package org.example.controller;

import org.example.model.Account;
import org.example.model.Client;
import org.example.service.AccountSevice;
import org.utils.UserInputException;

public class UserMenu  {

    Client client;
    AccountMenu accountMenu;



    MainMenu menu;

    public UserMenu(MainMenu menu, Client client) {
        this.menu = menu;
        this.client = client;
    }

    public UserMenu(){

    }

    public void viewUserMenu() throws UserInputException{

        System.out.println("--------------------------");
        System.out.println("USER MENU\n");
        System.out.println("1. Войти в аккаунт");
        System.out.println("2. Добавить аккаунт");
        System.out.println("3. Посмотреть свои аккаунты");
        System.out.println("4. Изменить информацию");
        System.out.println("5. Посмотреть информацию о себе");
        System.out.println("6. Назад");
        System.out.println("\n7. Закончить\n");
        System.out.println("--------------------------");

        System.out.println("Выберите пункт\n");

        selectUserMenu();
    }

    public void selectUserMenu() throws UserInputException {
        switch(menu.userInput()){
            case 1:
                /*
                -> AccountMenu (для управления аккаунтами)
                 */
                Account account = menu.accountSevice.loginAccount(client);
                if(account != null){
                    accountMenu = new AccountMenu(menu,client,account,this);
                    accountMenu.viewAccountMenu();
                }
                else{
                    System.out.println("ВЕРНУЛСЯ NULL");
                }
                viewUserMenu();
                break;
            case 2:
                menu.accountSevice.registrationAccount(client);
                viewUserMenu();
                break;
            case 3:
                System.out.println(client.getAccountList());
                viewUserMenu();
                break;
            case 4:
                menu.clientService.editClientInfo(client);
                viewUserMenu();
                break;
            case 5:
                menu.clientService.viewClientInfo(client);
                viewUserMenu();
                break;
            case 6:
                menu.viewStartMenu();
                break;
            case 7:
                System.exit(1);
                break;

            default:
                System.out.println("ВЫ ВВЕЛИ ДРУГОЕ ЧИСЛО");
        }
    }
}

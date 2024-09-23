package org.example.service;

import org.example.model.Account;
import org.example.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountSevice {

    List<Account> accountList = new ArrayList<>();

    Account account;

    public AccountSevice(){

    }

    /*
    Регистрация по ID
     */
    public void registrationAccount(Client client){
        account = new Account();

        System.out.println("Введите идентификатор для вашего аккаунта");
        Scanner scanner = new Scanner(System.in);
        int identificator = scanner.nextInt();
        account.setAccountId(identificator);

        while(accountList.contains(account)){
            System.out.println("Данный ID уже занят другим аккаунтом");
            identificator = scanner.nextInt();
            account.setAccountId(identificator);
        }

        accountList.add(account);
        System.out.println("Вы успешно зарегистрировали аккаунт!");
        client.addToList(account);

    }

    /*
    Вход по ID
     */
    public Account loginAccount(Client client){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ID аккаунта, в который хотите войти");

        int id = scanner.nextInt();

        Account account = new Account();
        account.setAccountId(id);

        while(getAccountList().contains(account)) {
            if (client.getAccountList().contains(account)) {
                System.out.println("Да, у вас есть этот аккаунт!");
                return accountList.get(accountList.indexOf(account));
            }
            else{
                System.out.println("Этот аккаунт не принадлежит вам!");
                System.out.println("Введите заново ID");
                id = scanner.nextInt();
                account.setAccountId(id);
            }
        }

        System.out.println("У вас нету данного аккаунта!");
        return null;

//        account = new Account();
//        Scanner scanner = new Scanner(System.in);
//        int identificator = scanner.nextInt();
//        account.setAccountId(identificator);


    }

    /*
    Все аккаунты которые есть
     */
    public void selectAccounts(){
        System.out.println(accountList);
    }

    public List<Account> getAccountList(){
        return accountList;
    }

}

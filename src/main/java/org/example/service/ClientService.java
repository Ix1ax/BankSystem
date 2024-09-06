package org.example.service;

import org.example.model.Client;
import org.example.model.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientService {

    List<Client> clientList = new ArrayList<>();

    Client client;

    public ClientService(){
        client = new Client();
        client.setLogin("Admin");
        client.setPassword("Admin");
        client.setRole(Role.ADMIN);
        clientList.add(client);

        Client client2 = new Client();
        client2.setLogin("test");
        client2.setPassword("test");
        client2.setRole(Role.USER);
        clientList.add(client2);

    }


    /*
    Метод для создания логина у клиента
     */
    public void addClient(Client client) {
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        client.setLogin(login);

        /*
        Проверка на существующего пользователя
         */
        while (clientList.contains(client)) {
            System.out.println("Данный пользователь существует, нужен другой логин!");
            login = scanner.nextLine();
            client.setLogin(login);
        }
    }

    /*
    Новый админ
     */
    public void addAdmin(){
        client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин нового администратора");

//        client.setLogin(addClient(client).getLogin());
        addClient(client);

        System.out.println("Введите пароль нового администратора");
        String password = scanner.nextLine();
        client.setPassword(password);
        client.setRole(Role.ADMIN);
        clientList.add(client);

        System.out.println("Новый ADMIN был добавлен!");

    }

    /*
    Регистрация пользователя
     */
    public void registrationClient(){
        client = new Client();

        System.out.println("Введите логин");
        Scanner scanner = new Scanner(System.in);

//        client.setLogin(addClient(client).getLogin());

        addClient(client);

        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        System.out.println("Повторите пароль");
        String checkPassword = scanner.nextLine();
        /*
        Проверка на совпадение пароля
         */
        while(!password.equals(checkPassword)){
            System.out.println("Пароли не совпадают!");
            System.out.println("Введите пароль");
            password = scanner.nextLine();
            System.out.println("Повторите пароль");
            checkPassword = scanner.nextLine();
        }

        client.setPassword(password);
        client.setRole(Role.USER);
        /*
        Добавляем в структуру данных данного пользователя
         */
        clientList.add(client);
        System.out.println("Вы успешно зарегистрировались!");
    }

    public Client loginClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();

        /*
        Проверка существует ли такой пользователь
         */
        Client client = new Client();
        client.setLogin(login);
        if(!clientList.contains(client)){
            System.out.println("Данного пользователя нет или неправильный логин");
            return null;
        }

        int index = clientList.indexOf(client);

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        /*
        Проверка на пароль, что он реально совпадает с аккаунтом
         */
        if(clientList.get(index).getPassword().equals(password)){
            System.out.println("Вход выполнен успешно!");

            /*
            Возвращаем клиента который зарегистрировался
             */
//            return clientList.get(index).getRole();
            return clientList.get(index);
        }

        else{
            System.out.println("Неправильный пароль");
            return null;
        }
    }

    /*
    Изменение информации о клиентах
     */
    public void editClientInfo(Client client){
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите новый Логин");

//        addClient(client);

        /*
        -> Для функции edit -> при изменении login у клиента.
         Меняется сразу он в ArrayList
         Login поменять нельзя будет
         */

        System.out.println("Введите новый Пароль");
        String password = scanner.nextLine();
        System.out.println("Введите свое Имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите свою Фамилию");
        String secondName = scanner.nextLine();
        System.out.println("Введите код паспорта");
        int passportId = scanner.nextInt();

        client.setPassword(password);
        client.setFirstName(firstName);
        client.setSecondName(secondName);
        client.setPassportId(passportId);

        /*
        TODO (Не может быть людей с одинаковыми паспортами)
         */

    }

    /*
    Просмотр информации о клиентах
     */
    public void viewClientInfo(Client client){
        System.out.println("Логин: " +  client.getLogin());
        System.out.println("Пароль: " +  client.getPassword());
        System.out.println("Имя: " +  client.getFirstName());
        System.out.println("Фамилия: " +  client.getSecondName());
        System.out.println("ПаспортИД: " +  client.getPassportId());
    }

    public void selectClients(){
        System.out.println(clientList);
    }
}

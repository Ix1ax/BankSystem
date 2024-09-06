package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Client {

    /*
    Данные для входа
     */
    private String login;
    private String password;

    /*
    Информация о пользователе
     */
    private int clientId;
    private static int id = 0;
    private String firstName;
    private String secondName;
    private int passportId;
    private Role role;

    /*
    Список аккаунтов
     */
    private List<Account> accountList;

    public Client() {
        accountList = new ArrayList<>();
        clientId = id;
        id++;
    }

//    public Client(){
//
//    }

    /*
    SETTER AND GETTERS
     */

    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        Client.id = id;
    }

    public int getClientId(){
        return clientId;
    }
    public void setClientId(int clientId){
        this.clientId = clientId;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getSecondName(){
        return secondName;
    }
    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public int getPassportId(){
        return passportId;
    }
    public void setPassportId(int passportId){
        this.passportId = passportId;
    }

    public Role getRole(){
        return role;
    }
    public void setRole(Role role){
        this.role = role;
    }

    public List<Account> getAccountList(){
        return accountList;
    }
    public void setAccountList(List<Account> list){
        this.accountList = list;
    }

    // METHODS

    public void addToList(Account account){
        accountList.add(account);
    }

//    public void editInfo(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите новый Логин:");
//        String login = scanner.nextLine();
//        System.out.println("Введите новый Пароль:");
//        String password = scanner.nextLine();
//
//    }
//
//    public void getInfo(){
//
//    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", passportId=" + passportId +
                ", accountList=" + accountList +
                '}' + "\n";
    }

    //    public String toString(){
//        return "USER(" + clientId + " , " + login + " , " + password + " , "  + role + ")";
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(login, client.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

}



package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {

    private int accountId;
    private double balance;

    /*
    Списки кредитов и операций у данного аккаунта
     */
    private List<Transaction> transactionList;
    private List<Credit> creditList;

    public Account(){
        this.balance = 0;
        this.transactionList = new ArrayList<>();
        this.creditList = new ArrayList<>();
    }

    /*
    SETTER AND GETTER
     */

    public int getAccountId(){
        return accountId;
    }
    public void setAccountId(int accountId){
        this.accountId = accountId;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public List<Transaction> getTransactionList(){
        return transactionList;
    }
    public void setTransactionList(List<Transaction> list) {
        this.transactionList = list;
    }

    public List<Credit> getCreditList(){
        return creditList;
    }
    public void setCreditList(List<Credit> list){
        this.creditList = list;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", transactionList=" + transactionList +
                ", creditList=" + creditList +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }
}

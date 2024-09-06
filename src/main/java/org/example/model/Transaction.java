package org.example.model;

public class Transaction {
    private TransactionType type;
    private double amount;

    private Account recAccount;

    public Transaction(){

    }

    /*
    SETTER AND GETTER
     */

    public TransactionType getType(){
        return type;
    }
    public void setType(TransactionType type){
        this.type = type;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

    public Account getRecAccount(){
        return recAccount;
    }
    public void setRecAccount(Account recAccount){
        this.recAccount = recAccount;
    }

}

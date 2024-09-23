package org.example.model;

public class Transaction {
    private TransactionType type;
    private double amount;

    private Status transactionStatus;
    private Account transactionAccount;

    public Transaction(){
        transactionAccount = null;
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

    public void setTransactionStatus(Status status){
        this.transactionStatus = status;
    }
    public Status getTransactionStatus(){
        return transactionStatus;
    }

    public void setTransactionAccount(Account account){
        this.transactionAccount = account;
    }
    public Account getTransactionAccount(){
        return transactionAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", amount=" + amount +
                ", status=" + transactionStatus +
                ", transactionAccount=" + transactionAccount +
                '}' + "\n";
    }
}

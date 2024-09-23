package org.example.service;

import org.example.model.Account;
import org.example.model.Status;
import org.example.model.Transaction;
import org.example.model.TransactionType;

import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class TransactionService {
    Transaction transaction;

    public TransactionService(){

    }

    /*
    Пополнение баланса у аккаунта
    */
    public void replenishment(Account account){
        transaction = new Transaction();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму на которую хотите пополнить баланс. Введите 0 для отмены");
        double amount = scanner.nextDouble();
        while(amount < 0){
            // TODO Exception
            System.out.println("Вы не можете пополнить на отрицательную сумму. Введите новую сумму или 0 для отмены:");
            amount = scanner.nextDouble();
        }

        transaction.setType(TransactionType.REPLENISHMENT);

        /*
        Отмена операции
         */
        if(amount == 0){
            System.out.println("Операция отменена!");
            transaction.setTransactionStatus(Status.CANCEL);
        } else {
            transaction.setTransactionStatus(Status.SUCCESS);
        }

        transaction.setAmount(amount);

        account.setBalance(transaction.getAmount());
        account.getTransactionList().add(transaction);

    }

    /*
    Снятие баланса у аккаунта
     */
    public void withdrawal(Account account){
        transaction = new Transaction();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму на которую хотите снять баланс. Введите 0 для отмены: ");
        double amount = scanner.nextDouble();
        while(amount < 0 || account.getBalance() < amount){
            // TODO Exception
            if(account.getBalance() < amount){
                System.out.println("Ваш баланс меньше того, который вы хотите снять. Введите новую сумму или 0 для отмены: ");
            }
            else {
                System.out.println("Вы не можете пополнить на отрицательную сумму. Введите новую сумму или 0 для отмены: ");
            }

            amount = scanner.nextDouble();
        }


        transaction.setType(TransactionType.WITHDRAWAL);

        /*
        Отмена операции
         */
        if(amount == 0){
            System.out.println("Операция отменена!");
            transaction.setTransactionStatus(Status.CANCEL);
        } else {
            transaction.setTransactionStatus(Status.SUCCESS);
        }

        transaction.setAmount(amount);


        /*
        Изменяем баланс и добавляем транзакцию
         */
        account.setBalance(account.getBalance() - amount);
        account.getTransactionList().add(transaction);

    }

    /*
    Перевод другому пользователю баланса
     */
    public void transfer(Account account, AccountSevice accountSevice){
        /*
        TODO аккаунт не существует
         */
        transaction = new Transaction();
        System.out.println("Введите ID пользователя, которому хотите совершить перевод или 0 для отмены: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        /*
        Отмена
         */
        if(id == 0){
            transaction.setAmount(0);
            transaction.setTransactionStatus(Status.CANCEL);
            transaction.setType(TransactionType.TRANSFER);
            account.getTransactionList().add(transaction);
            return;
        } else {
            Account transferAccount = new Account();
            transferAccount.setAccountId(id);
            /*
            Проверка, что такого аккаунта нет
            TODO тут ошибка
             */
            while (!(accountSevice.getAccountList().contains(transferAccount))){
                System.out.println("Данного аккаунта не существует. Введите новый ID или 0 для отмены: ");
                id = scanner.nextInt();
                if(id == 0){
                    transaction.setAmount(0);
                    transaction.setTransactionStatus(Status.CANCEL);
                    transaction.setType(TransactionType.TRANSFER);
                    account.getTransactionList().add(transaction);
                    return;
                }
            }

            /*
            Сумма для перевода
             */
            System.out.println("Введите сумму которую хотите перевести: ");
            double amount = scanner.nextDouble();
            while(amount <= 0 || account.getBalance() < amount){
                // TODO Exception
                if(account.getBalance() < amount){
                    System.out.println("Ваш баланс меньше того, который вы хотите снять:  ");
                }
                else {
                    System.out.println("Вы не можете перевести отрицательную или равную 0 сумму. Введите новую сумму: ");
                }

                amount = scanner.nextDouble();
            }

            int accountIndex = accountSevice.getAccountList().indexOf(transferAccount);
            transaction.setTransactionAccount(accountSevice.getAccountList().get(accountIndex));
            transaction.setTransactionStatus(Status.SUCCESS);
            transaction.setAmount(amount);

            accountSevice.getAccountList().get(accountIndex).setBalance(accountSevice.getAccountList().get(accountIndex).getBalance() + amount);

            account.setBalance(account.getBalance() - amount);

            account.getTransactionList().add(transaction);


        }



    }

}


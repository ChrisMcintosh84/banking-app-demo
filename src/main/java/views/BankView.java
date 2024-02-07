package views;

import controllers.FileHandler;
import models.BankAccount;

import java.util.Scanner;

public class BankView {

    private Scanner input = new Scanner(System.in);

    public int getMainMenuChoice() {
        System.out.println("Welcome to Bank App");
        System.out.println("==================================");
        System.out.println("Please choose from the following: ");
        System.out.println("1) Accounts");
        System.out.println("2) Exit");

        return input.nextInt();
    }

    public int getAccountMenuChoice() {
        System.out.println("Account Menu");
        System.out.println("==================================");
        System.out.println("Please choose from the following: ");
        System.out.println("1) List accounts");
        System.out.println("2) Make transaction");
        System.out.println("3) Create account");
        System.out.println("4) Delete account");
        System.out.println("5) Return to previous menu");

        return input.nextInt();
    }

    public int getTransactionMenuChoice() {
        System.out.println("Transaction Menu");
        System.out.println("==================================");
        System.out.println("Please choose from the following: ");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Return to previous menu");

        return input.nextInt();
    }

    public BankAccount getBankAccount() {
        System.out.println("Enter account number: ");
        String accountNumber = input.next();

        System.out.println("Enter current balance: ");
        double currentBalance = input.nextDouble();

        System.out.println("Is this correct? Account number: " + accountNumber + ", Current balance: " + currentBalance + " (Y/N)");
        String choice = input.next().toLowerCase();

        if (choice.equals("y")) {
            return new BankAccount(accountNumber, currentBalance);
        }
        return null;
    }

    public BankAccount getTransaction() {
        System.out.println("Enter account number: ");
        String accountNumber = input.next();

        System.out.println("Enter amount: ");
        double amount = input.nextDouble();

        System.out.println("Is this correct? Account number: " + accountNumber + ", Amount: " + amount + " (Y/N)");
        String choice = input.next().toLowerCase();

        if (choice.equals("y")) {
            return new BankAccount(accountNumber, amount);
        }
        return null;
    }

    public String getAccountToDelete() {
        System.out.println("Enter account number to delete: ");
        String accountNumber = input.next();

        System.out.println("Is this correct? Account number: " + accountNumber + " (Y/N)");
        String choice = input.next().toLowerCase();

        if (choice.equals("y")) {
            return accountNumber;
        }
        return null;
    }
}
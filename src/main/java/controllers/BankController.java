package controllers;

import models.BankAccount;
import views.BankView;

import java.util.List;
import java.util.Objects;

public class BankController {
    private BankView view;
    private FileHandler fileHandler;

    public BankController(BankView view, FileHandler fileHandler) {
        this.view = view;
        this.fileHandler = fileHandler;
    }

    public void init() {
        processMainMenuInput();
    }

    private void processMainMenuInput() {
        int choice;

        while (true) {
            choice = view.getMainMenuChoice();
            switch (choice) {
                case 1:
                    processAccountMenuInput();
                    break;
                case 2:
                    System.exit(1);
            }
        }
    }

    private void processAccountMenuInput() {
        int choice;

        while (true) {
            choice = view.getAccountMenuChoice();
            switch (choice) {
                case 1:
                    printAccounts();
                    break;
                case 2:
                    processTransactionMenuInput();
                    break;
                case 3:
                    processNewAccount();
                    break;
                case 4:
                    System.out.println("delete account");
                    break;
                case 5:
                    processMainMenuInput();
                    break;
            }
        }
    }

    private void processTransactionMenuInput() {
        int choice;

        while (true) {
            choice = view.getTransactionMenuChoice();
            switch (choice) {
                case 1:
                    processDeposit();
                    break;
                case 2:
                    processWithdrawal();
                    break;
                case 3:
                    processAccountMenuInput();
                    break;
            }
        }
    }

    private void processDeposit() {
        BankAccount bankAccount = view.getTransaction();

        List<BankAccount> accounts = fileHandler.getAccounts();

        for (BankAccount account: accounts) {
            if ((account.getAccountNumber().equals(bankAccount.getAccountNumber()))) {
                account.deposit(bankAccount.getBalance());
                fileHandler.addAccount(account);
            }
            else {
                System.out.println("Account number doesn't exist");
            }
        }
    }

    private void processWithdrawal() {
        BankAccount bankAccount = view.getTransaction();

        List<BankAccount> accounts = fileHandler.getAccounts();

        for (BankAccount account: accounts) {
            if ((account.getAccountNumber().equals(bankAccount.getAccountNumber()))) {
                account.withdraw(bankAccount.getBalance());
                fileHandler.addAccount(account);
            }
            else {
                System.out.println("Account number doesn't exist");
            }
        }
    }

    private void printAccounts() {
        System.out.println(fileHandler.getAccounts());
    }

    private void processNewAccount() {
        BankAccount bankAccount = view.getBankAccount();

        fileHandler.addAccount(bankAccount);
    }
}

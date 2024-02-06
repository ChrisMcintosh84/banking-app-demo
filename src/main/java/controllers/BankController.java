package controllers;

import models.Transaction;
import models.User;
import views.BankView;

public class BankController {
    private Transaction transaction;
    private BankView view;
    private FileHandler fileHandler;

    public BankController(Transaction transaction, BankView view, FileHandler fileHandler) {
        this.transaction = transaction;
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
                    processUserMenuInput();
                    break;
                case 2:
                    System.exit(1);
            }
        }
    }

    private void processUserMenuInput() {
        int choice;

        while (true) {
            choice = view.getUserMenuChoice();
            switch (choice) {
                case 1:
                    processAccountMenuInput();
                    break;
                case 2:
                    processNewUser();
                    break;
                case 3:
                    printUsers();
                    break;
                case 4:
                    processMainMenuInput();
                    break;
            }
        }
    }

    private void processAccountMenuInput() {
        int choice;

        while (true) {
            choice = view.getAccountMenuChoice();
            switch (choice) {
                case 1:
                    System.out.println("list accounts");
                    break;
                case 2:
                    System.out.println("make transaction");
                    break;
                case 3:
                    System.out.println("create account");
                    break;
                case 4:
                    System.out.println("delete account");
                    break;
                case 5:
                    processUserMenuInput();
                    break;
            }
        }
    }

    private void printUsers() {
        System.out.println(fileHandler.getUsernames());
    }

    private void processNewUser() {
        User user = view.getUser();

        fileHandler.addUser(user);
    }
}

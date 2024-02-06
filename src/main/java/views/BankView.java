package views;

import controllers.FileHandler;
import models.User;

import java.util.Scanner;

public class BankView {

    private static FileHandler fileHandler = new FileHandler();
    private Scanner input = new Scanner(System.in);

    public int getMainMenuChoice() {
        System.out.println("Welcome to Bank App");
        System.out.println("==================================");
        System.out.println("Please choose from the following: ");
        System.out.println("1) User selection");
        System.out.println("2) Exit");

        return input.nextInt();
    }

    public int getUserMenuChoice() {
        System.out.println("Welcome to Bank App");
        System.out.println("==================================");
        System.out.println("Please choose from the following: ");
        System.out.println("1) Enter username");
        System.out.println("2) Create new user");
        System.out.println("3) List users");
        System.out.println("4) Return to previous menu");

        return input.nextInt();
    }

    public int getAccountMenuChoice() {
        System.out.println("Welcome to Bank App");
        System.out.println("==================================");
        System.out.println("Please choose from the following: ");
        System.out.println("1) List accounts");
        System.out.println("2) Make transaction");
        System.out.println("3) Create account");
        System.out.println("4) Delete account");
        System.out.println("5) Return to previous menu");

        return input.nextInt();
    }

    public User getUser() {
        System.out.println("Enter id for user: ");
        int id = input.nextInt();

        System.out.println("Enter name for user: ");
        String name = input.next();

        System.out.println("Is this correct? Id: " + id + " models.User: " + name + " Y/N");
        String choice = input.next().toLowerCase();

        User user = new User();
        user.setUserId(id);
        user.setUserName(name);

        if (choice.equals("y")) {
            return user;
        }
        return null;
    }

//    private static void personalMenu() {
//        while (true) {
//            int userChoice = buildPersonalMenu();
//
//            switch (userChoice) {
//                case 1:
//                    listAccounts();
//                    break;
//                case 2:
//                    makeTransaction();
//                    break;
//                case 3:
//                    createAccount();
//                    break;
//                case 4:
//                    deleteAccount();
//                    break;
//                case 5:
//                    userMenu();
//            }
//        }
//    }
}
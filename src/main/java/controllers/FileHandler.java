package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.BankAccount;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {
    private final String accountsFilePath = "src/main/resources/accounts.json";
    private List<BankAccount> accountList = new ArrayList<>();

    public List<BankAccount> getAccounts() {
        try {
            accountList = readJson();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return accountList;
    }

    public void addAccount(BankAccount bankAccount) {
        try {
            getAccounts();
            if (accountList == null) {
                accountList = new ArrayList<>();
            }

            accountList.add(bankAccount);

            writeBankAccountsToJson(accountList);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<BankAccount> readJson() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(accountsFilePath));
        Gson gson = new Gson();

        return gson.fromJson(bufferedReader, new TypeToken<List<BankAccount>>(){}.getType());
    }

    private void writeBankAccountsToJson(List<BankAccount> bankAccounts) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        FileWriter fileWriter = new FileWriter(accountsFilePath);
        fileWriter.append(gson.toJson(bankAccounts));
        fileWriter.close();
    }
}

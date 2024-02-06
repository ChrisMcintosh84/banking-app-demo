package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private final String userFilePath = "src/main/resources/users.json";
    private List<User> userList = new ArrayList<>();

    public List<User> getUsers() {
        try {
            userList = readJson();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void addUser(User user) {
        try {
            writeUserToJson(user);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> readJson() throws FileNotFoundException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(userFilePath));

        List<User> userList = new ArrayList<>();
        User user = gson.fromJson(bufferedReader, User.class);
        userList.add(user);
        return userList;
    }

    private void writeUserToJson(User user) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        FileWriter fileWriter = new FileWriter(userFilePath);
        fileWriter.append(gson.toJson(user));
        fileWriter.close();
    }

    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<>();

        try {
            userList = readJson();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for (User user : userList) {
            usernames.add(user.getUserName());
        }

        return usernames;
    }
}

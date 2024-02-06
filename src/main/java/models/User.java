package models;

import java.util.Arrays;

public class User {
    private int userId;
    private String userName;
    private int[] userAccounts;

    public User() {
    }

    public User(int userId, String userName, int[] userAccounts) {
        this.userId = userId;
        this.userName = userName;
        this.userAccounts = userAccounts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int[] getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(int[] userAccounts) {
        this.userAccounts = userAccounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAccounts=" + Arrays.toString(userAccounts) +
                '}';
    }
}

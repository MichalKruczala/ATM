package com.company.users;

public class User {
    public final String login;
    public final String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;

    }

    public boolean tryAuthenticate(String login, String password) {
        return this.login == login && this.password == password;
    }
}

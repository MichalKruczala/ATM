package pl.kruczala.michal.db;

import pl.kruczala.michal.User;

import java.util.ArrayList;

public class UserDB {
    private final ArrayList<User> usersInSystem;

    public ArrayList<User> getUsersInSystem() {
        return this.usersInSystem;
    }

    public UserDB() {
        this.usersInSystem = new ArrayList<User>();
        usersInSystem.add(new User("123", "f77fe34c4c360ccb53e2ed84d246965e"));
        usersInSystem.add(new User("admin", "c037c93bf16b63ce908b98e280ccffef", true));
        usersInSystem.add(new User("jareczek", "c3b5059804dbcc59bc4daaf93585a3a6"));
        usersInSystem.add(new User("grzesiek", "884c61ecd3b018e72579db88fe4b2d10"));
        usersInSystem.add(new User("michal", "5804c3b43db92e5c7987a287d7e60089"));
    }
}

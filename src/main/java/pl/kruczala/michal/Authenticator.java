package pl.kruczala.michal;

import java.util.ArrayList;

public class Authenticator {

    private ArrayList<User> usersInSystem;


    public Authenticator() {

        this.usersInSystem = new ArrayList<User>();
        usersInSystem.add(new User("123", "123"));
        usersInSystem.add(new User("jareczek123", "ciastkonakielny"));
        usersInSystem.add(new User("grzesiek123", "brakciasta"));
        usersInSystem.add(new User("michal123", "tylkodance"));

    }

    public boolean tryAunthenticate(User user) {

        return usersInSystem.contains(user);
    }
}

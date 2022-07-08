package pl.kruczala.michal;

import java.util.ArrayList;
import java.util.Optional;

public class Authenticator {

    private ArrayList<User> usersInSystem;
    public ArrayList<User> getUsersInSystem(){
        return this.usersInSystem;
    }

    public Authenticator() {

        this.usersInSystem = new ArrayList<User>();
        usersInSystem.add(new User("123", "123"));
        usersInSystem.add(new User("admin", "admin",true));
        usersInSystem.add(new User("jareczek123", "ciastkonakielny"));
        usersInSystem.add(new User("grzesiek123", "brakciasta"));
        usersInSystem.add(new User("michal123", "tylkodance"));

    }

    public User tryAunthenticate(String login, String password) {

        Optional<User> opcjonalna =
                usersInSystem.stream().filter(user -> user.login.equals(login) && user.password.equals(password)).findAny();
        if (opcjonalna.isEmpty()){
            return null;
        }
        User result = opcjonalna.get();
        return  result;

    }

}

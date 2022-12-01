package pl.kruczala.michal.authenticator;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kruczala.michal.prividers.OptionsProvider;
import pl.kruczala.michal.model.User;
import pl.kruczala.michal.db.UserDB;
import pl.kruczala.michal.gui.GUI;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class Authenticator {
    @Autowired
    OptionsProvider optionsProvider;
    @Autowired

    UserDB userDB;
    @Autowired

    GUI gui;

    private String seed = "SIEMANOKOLANO";

    public Authenticator() {

    }

    public boolean tryAuthenticate() throws IOException {
        System.out.print("Login:");
        String login = optionsProvider.readString();
        System.out.print("Password:");
        String password = DigestUtils.md5Hex(optionsProvider.readString() + seed);
        User user = verifyUser(login, password);
        if (user == null) {
            gui.printWrongCredentials();
            tryAuthenticate();
        }
        return true;
    }

    public User verifyUser(String login, String password) {

        Optional<User> opcjonalna =
                userDB.getUsersInSystem().stream().filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password)).findAny();
        if (opcjonalna.isEmpty()) {
            return null;
        }
        User result = opcjonalna.get();
        if (result.isAdmin) {
            for (User user : userDB.getUsersInSystem()) {
                System.out.println("Login: " + user.getLogin() + " Password: " + user.getPassword() + " Is admin?: " + user.isAdmin);
            }
        }
        return result;
    }
}

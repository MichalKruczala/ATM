package pl.kruczala.michal.authenticator;

import org.apache.commons.codec.digest.DigestUtils;
import pl.kruczala.michal.OptionsProvider;
import pl.kruczala.michal.User;
import pl.kruczala.michal.db.UserDB;
import pl.kruczala.michal.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Authenticator {
    OptionsProvider optionsProvider = new OptionsProvider();
    UserDB userDB = new UserDB();
    GUI gui = new GUI();




    private String seed = "SIEMANOKOLANO";

    public Authenticator() {

    }

    public boolean tryAuthenticate() throws IOException {

        gui.printHello();
        System.out.print("Login:");
        String login = optionsProvider.readString();
        System.out.print("Password:");
        String password = DigestUtils.md5Hex(optionsProvider.readString() + seed);

        User user = verifyUser(login, password);
        if (user == null) {
            gui.printWrongCredentials();
            tryAuthenticate();
        }
        assert user != null;
        if (user.isAdmin) {
            System.out.println(Arrays.toString(userDB.getUsersInSystem().toArray()));
        }
        return true;
    }

    public User verifyUser(String login, String password) {

        Optional<User> opcjonalna =
                userDB.getUsersInSystem().stream().filter(user -> user.login.equals(login) && user.password.equals(password)).findAny();
        if (opcjonalna.isEmpty()) {
            return null;
        }
        User result = opcjonalna.get();
        return result;

    }

}

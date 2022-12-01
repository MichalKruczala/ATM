package pl.kruczala.michal.model;

public class User {
    public boolean isAdmin;
    private final String login;
    private final String password;


    public User(String login, String password, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public static User isAdmin(String login, String password) {

        return new User(login, password, true);
    }


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User arrivedUser = (User) o;
        return this.login.equals(arrivedUser.login) && this.password.equals(arrivedUser.password);

    }

    public boolean isAdmin() {
        return isAdmin;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
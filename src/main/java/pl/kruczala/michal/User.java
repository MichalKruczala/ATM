package pl.kruczala.michal;

public class User {
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User arrivedUser = (User) o;
        return this.login.equals(arrivedUser.login)  && this.password.equals(arrivedUser.password);

    }


        public final String login;
        public final String password;

    public User(String login, String password, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //to jest metoda wytwórcza,na rozmowie pytają :)
    public static User isAdmin(String login, String password){

        return new User(login,password,true);
    }

    public boolean isAdmin;

    public User(String login, String password) {
            this.login = login;
            this.password = password;
        }
    }


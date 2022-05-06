package pl.kruczala.michal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthenticotorTests {
    @Test
    public void shouldAuthenticateValidUser() {
        Authenticator authenticator = new Authenticator();
        boolean isAuthenticated = authenticator.tryAunthenticate(new User("jareczek123", "ciastkonakielny"));
        Assertions.assertTrue(isAuthenticated);
    }

    @Test
    public void shouldNotAuthenticateInvalidUser() {
        Authenticator authenticator = new Authenticator();
        boolean isAuthenticated = authenticator.tryAunthenticate(new User("jarecuggyg3", "ciastkonakielnuygugy"));
        Assertions.assertFalse(isAuthenticated);
    }

}


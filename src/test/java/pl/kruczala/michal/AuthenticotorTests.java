package pl.kruczala.michal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthenticotorTests {
    @Test
    public void shouldAuthenticateValidUser() {
        Authenticator authenticator = new Authenticator();
        User isAuthenticated = authenticator.tryAunthenticate("jareczek123", "ciastkonakielny");
        Assertions.assertNotNull(isAuthenticated);
    }

    @Test
    public void shouldNotAuthenticateInvalidUser() {
        Authenticator authenticator = new Authenticator();
        User isAuthenticated = authenticator.tryAunthenticate("jarecuggyg3", "ciastkonakielnuygugy");
        Assertions.assertNull(isAuthenticated);
    }

}


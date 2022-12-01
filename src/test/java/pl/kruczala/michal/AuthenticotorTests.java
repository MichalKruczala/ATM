package pl.kruczala.michal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kruczala.michal.authenticator.Authenticator;

public class AuthenticotorTests {
    @Test
    public void shouldAuthenticateValidUser() {
        Authenticator authenticator = new Authenticator();
        User isAuthenticated = authenticator.verifyUser("jareczek123", "ciastkonakielny");
        Assertions.assertNotNull(isAuthenticated);
    }

    @Test
    public void shouldNotAuthenticateInvalidUser() {
        Authenticator authenticator = new Authenticator();
        User isAuthenticated = authenticator.verifyUser("jarecuggyg3", "ciastkonakielnuygugy");
        Assertions.assertNull(isAuthenticated);
    }

}


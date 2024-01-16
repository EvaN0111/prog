package gr.aueb.dmst.ecg.eprog;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserDAOTest {

    @Test
    public void testAuthenticateSuccess() {
        UserDAO userDAO = new UserDAO();
        String validUserName = "evan";
        String validPassword = "hello";

        assertDoesNotThrow(() -> {
            assertTrue(userDAO.authenticate(validUserName, validPassword));
        });
    }

    @Test
    public void testAuthenticateFailure() {
        UserDAO userDAO = new UserDAO();
        String invalidUserName = "invalidUser";
        String invalidPassword = "invalidPassword";

        assertDoesNotThrow(() -> {
            assertFalse(userDAO.authenticate(invalidUserName, invalidPassword));
        });
    }

}

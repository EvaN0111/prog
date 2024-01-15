import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserDAOTest {

    @Test
    public void testAuthenticateSuccess() {
        UserDAO userDAO = new UserDAO();
        String validUserName = "validUser";
        String validPassword = "validPassword";

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

    @Test
    public void testAuthenticateException() {
        UserDAO userDAO = new UserDAO();
        String exceptionMessage = "Test exception message";

        // Mock the DB class to throw an exception
        DB.setMockException(true);

        Exception exception = assertThrows(Exception.class, () -> {
            userDAO.authenticate("testUser", "testPassword");
        });

        assertEquals(exceptionMessage, exception.getMessage());
        // Reset the mock after the test
        DB.setMockException(false);
    }
}

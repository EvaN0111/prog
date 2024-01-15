import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

    @Test
    public void testOpenConnection() {
        // Test if openConnection method returns a non-null Connection
        Connection connection = DB.openConnection();
        assertNotNull(connection);

        // Test if the connection is open
        try {
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail("Exception thrown while checking connection status: " + e.getMessage());
        }
    }

    @Test
    public void testCreateTables() {
        // Test if createTables method executes without throwing an exception
        Connection connection = DB.openConnection();
        assertDoesNotThrow(() -> {
            DB.createTables(connection);
        });

        // Test if tables are created (you may need to customize this based on your actual implementation)
        try (Statement stmt = connection.createStatement()) {
            assertTrue(stmt.execute("SELECT * FROM Input"));
            assertTrue(stmt.execute("SELECT * FROM Genres"));
            assertTrue(stmt.execute("SELECT * FROM Playlists"));
        } catch (SQLException e) {
            fail("Exception thrown while executing SQL queries: " + e.getMessage());
        }
    }

    @Test
    public void testClose() {
        // Test if close method executes without throwing an exception
        assertDoesNotThrow(() -> {
            DB.close();
        });

        // Add more specific tests based on your actual implementation and requirements
    }

    // You can add more specific tests for other methods in the DB class as needed
}

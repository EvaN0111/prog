import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.SQLException;

public class DBconnectionTest {

    @Test
    public void testDbcon() {
        DBconnection dbConnection = new DBconnection();

        // Test if the method executes without throwing an exception
        assertDoesNotThrow(() -> {
            dbConnection.dbcon();
        });

        // Alternatively, you can test the behavior more specifically based on your requirements
        // For example, you can check if the connection is not null
        Connection connection = DB.getConnection(); // Assuming you have a getConnection() method in your DB class
        assertNotNull(connection);

        // You can also check if the tables are created successfully
        // Assuming you have a method createTables() that creates tables in your DB class
        // Note: Modify this part based on how your createTables method behaves
        try {
            assertTrue(DB.tablesExist(connection)); // Assuming tablesExist() checks if tables exist
        } catch (SQLException e) {
            fail("Exception thrown while checking tables existence: " + e.getMessage());
        }

        // Add more specific tests based on your actual implementation and requirements
    }
}

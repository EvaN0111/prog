import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.sql.*;

public class SavecountTest {

    private static final String TEST_DB_URL = "jdbc:sqlite:TestDatabase.db";

    @Before
    public void setup() {
        try (Connection connection = DriverManager.getConnection(TEST_DB_URL)) {
            String createTableQuery = "CREATE TABLE Genres (UserName TEXT, Rock INTEGER, Pop INTEGER)";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableQuery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIncreaseCounter() {
        Savecount savecount = new Savecount();
        savecount.setDB_URL(TEST_DB_URL); 

        boolean result = savecount.increaseCounter("Rock", "John");

        assertTrue(result);

        try (Connection connection = DriverManager.getConnection(TEST_DB_URL)) {
            String selectQuery = "SELECT Rock FROM Genres WHERE UserName = 'John'";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
                    assertTrue(resultSet.next());
                    int rockCount = resultSet.getInt("Rock");
                    assertEquals(1, rockCount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

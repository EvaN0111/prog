package gr.aueb.dmst.ecg.eprog;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SavecountTest {

    private static final String TEST_DB_URL = "jdbc:sqlite:UserInput.db";
    private static final String TEST_GENRE = "Pop";
    private static final String TEST_USER_NAME = "eva";

    private Savecount savecount;

    @Before
    public void setUp() throws SQLException {
        // Set up the initial state of the in-memory database
        Connection connection = DriverManager.getConnection(TEST_DB_URL);
        Statement statement = connection.createStatement();

        // Insert a test user
        String insertUserQuery = "INSERT INTO Genres (UserName) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
            preparedStatement.setString(1, TEST_USER_NAME);
            preparedStatement.executeUpdate();
        }

        // Close resources
        statement.close();
        connection.close();

        // Initialize the Savecount class with the in-memory database
        savecount = new Savecount();
    }

    @After
    public void tearDown() throws SQLException {
        // Clean up resources
        Connection connection = DriverManager.getConnection(TEST_DB_URL);
        Statement statement = connection.createStatement();

        // Clear the test data
        String clearDataQuery = "DELETE FROM Genres";
        statement.executeUpdate(clearDataQuery);

        // Close resources
        statement.close();
        connection.close();
    }

    @Test
    public void testIncreaseCounter() {
        // Call the method under test
        boolean result = savecount.increaseCounter(TEST_GENRE, TEST_USER_NAME);

        // Add your assertions based on your requirements
        assertTrue(result);

        // You can also perform additional checks, such as querying the database to verify the result
    }
}

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

public class SignUpTest {

    private static final String TEST_DB_URL = "jdbc:sqlite:UserInput.db";
    private static final String TEST_USERNAME = "fani";
    private static final String TEST_PASSWORD = "647382";
    private static final String TEST_FULLNAME = "fani ts";

    private SignUp signUp;

    @Before
    public void setUp() throws SQLException {
        // Set up the initial state of the in-memory database
        Connection connection = DriverManager.getConnection(TEST_DB_URL);
        Statement statement = connection.createStatement();

        // Insert a test user into the Input table
        String insertUserQuery = "INSERT INTO Input (UserName, Password, Fullname) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
            preparedStatement.setString(1, TEST_USERNAME);
            preparedStatement.setString(2, TEST_PASSWORD);
            preparedStatement.setString(3, TEST_FULLNAME);
            preparedStatement.executeUpdate();
        }

        // Close resources
        statement.close();
        connection.close();

        // Initialize the SignUp class with the in-memory database
        signUp = new SignUp();
    }

    @After
    public void tearDown() throws SQLException {
        // Clean up resources
        Connection connection = DriverManager.getConnection(TEST_DB_URL);
        Statement statement = connection.createStatement();

        // Clear the test data
        String clearDataQuery = "DELETE FROM Input";
        statement.executeUpdate(clearDataQuery);

        // Close resources
        statement.close();
        connection.close();
    }

    @Test
    public void testCheckAvailability() {
        // Call the method under test
        boolean result = signUp.checkAvailability(TEST_USERNAME);

        // Add assertions
        assertFalse(result);  // Since the user was inserted in the setup, availability should be true
    }

    @Test
    public void testInsertData() {
        // Call the method under test
        boolean result = signUp.insertData(TEST_FULLNAME, TEST_USERNAME, TEST_PASSWORD);

        // Add assertions
        assertFalse(result);
    }

    @Test
    public void testInitializingCounters() {
        // Call the method under test
        boolean result = signUp.initializingCounters(TEST_USERNAME);

        // Add assertions
        assertTrue(result);
    }
}

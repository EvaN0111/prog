package gr.aueb.dmst.ecg.eprog;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DBconnectionTest {

    @Test
    public void testDbcon() {
        DBconnection dbConnection = new DBconnection();

        // Test if the method executes without throwing an exception
        assertDoesNotThrow(() -> {
            dbConnection.dbcon();
        });

    }
}

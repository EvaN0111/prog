package gr.aueb.dmst.ecg.eprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
            

public class Savecount {
    private static final String DB_URL ="jdbc:sqlite:UserInput.db";

    public boolean increaseCounter(String genre, String name) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            String updateQuery = "UPDATE Genres SET " +genre +"=" +genre +"+ 1 WHERE UserName = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, name);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

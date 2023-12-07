import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Counter {
    private static final String DB_URL ="jdbc:sqlite:UserInput.db";

    public static boolean increaseCounter(String genre) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            String updateQuery = "UPDATE music_genres SET counter = counter + 1 WHERE genre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, genre);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String[] genres = {"pop", "rock", "hip hop", "jazz", "house", "classic"};

        for (String genre : genres) {
            boolean updated = increaseCounter(genre);
            if (updated) {
                System.out.println("the counter for genre " + genre + "increased.");
            } else {
                System.out.println("the genre" + genre + "did not increase.");
            }
        }
    }
}
}
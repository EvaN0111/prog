package gr.aueb.dmst.ecg.eprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Genres {

    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public List<Integer> fetchData(String uname) {
        String url = "jdbc:sqlite:UserInput.db";
        List<Integer> genreList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "SELECT Pop, Rock, Rap, Jazz, HipHop, Classic, House FROM Genres WHERE UserName = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uname); // Set the parameter value
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                genreList.add(resultSet.getInt("Pop"));
                genreList.add(resultSet.getInt("Rock"));
                genreList.add(resultSet.getInt("Rap"));
                genreList.add(resultSet.getInt("Jazz"));
                genreList.add(resultSet.getInt("HipHop"));
                genreList.add(resultSet.getInt("Classic"));
                genreList.add(resultSet.getInt("House"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return genreList;
    }
}

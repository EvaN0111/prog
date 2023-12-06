package gr.aueb.dmst.ecg.eprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUp {
    
    public boolean checkAvailability(String un_check) {
        String url = "jdbc:sqlite:UserInput.db";
        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "SELECT UserName FROM Input WHERE UserName = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, un_check);
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;     
    }
    public boolean insertData(String fn_insert, String un_insert, String ps_insert) {
        String url = "jdbc:sqlite:UserInput.db";
        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO Input(Password, UserName, Fullname) VALUES(?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, ps_insert);
                preparedStatement.setString(2, un_insert);
                preparedStatement.setString(3, fn_insert);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean initializingCounters(String un_insert) {
        String url = "jdbc:sqlite:UserInput.db";
        int intial_counters = 0;
        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO Genre(UserName, Pop, Rock, Rap, Jazz, HipHop, Classic, House) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, un_insert);
                for (int i = 2; i <= 8; i++) {
                    preparedStatement.setInt(i, intial_counters);
                }
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

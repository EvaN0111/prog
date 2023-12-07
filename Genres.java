package gr.aueb.dmst.ecg.eprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Genres {
    public static void main(String[] args) {
        Genres genres = new Genres();
        String uname = un;
        String[] dataArray = fetchData(uname);
        for (String data : dataArray) {
            System.out.println(data);
        }
    }
    public static Map<String, Integer> fetchData(String uname) {

        Map<String, Integer> myMap = new HashMap<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null; 
        

        String url = "jdbc:sqlite:UserInput.db";
        myMap.put(uname, 0);
        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "SELECT UserName FROM Input WHERE UserName = ?";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next() && myMap.size() < 7) {
                String value = resultSet.getString("genre");
                myMap.add(value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Connection connection = null;
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return myMap.toArray(new String[0]);
    }
}

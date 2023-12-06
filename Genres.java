package gr.aueb.dmst.ecg.eprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Genres {
    public static void main(String[] args) {
        Genres genres = new Genres();
        String uname = un;
        String[] dataArray = fetchData(uname);
        for (String data : dataArray) {
            System.out.println(data);
        }
    }
    public static String[] fetchData(String uname) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null; 
        

        String url = "jdbc:sqlite:UserInput.db";
        ArrayList<String> dataList = new ArrayList<>();
        dataList.add(uname);
        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "SELECT UserName FROM Input WHERE UserName = ?";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next() && dataList.size() < 7) {
                String value = resultSet.getString("genre");
                dataList.add(value);
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
        return dataList.toArray(new String[0]);
    }
}

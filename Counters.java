package gr.aueb.dmst.ecg.eprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Counters extends Application {
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    Queue<String> queue = new LinkedList<>();
    static Map<String, Integer> genreCount = new HashMap<>();

    public Map<String, Integer> MGen(String name) {

        // create url and sql query
        String url = "jdbc:sqlite:UserInput.db";
        String sql = "SELECT Pop, Rock, Rap, Jazz, HipHop, Classic, House FROM Genres WHERE UserName = ?";

        try (
                // Establish a connection to the database
                Connection connection = DriverManager.getConnection(url);

                // Create a PreparedStatement with the SQL query
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            // Set the parameter value
            preparedStatement.setString(1, name);

            // Execute the query and get the ResultSet
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                // Get the ResultSetMetaData to retrieve column names
                ResultSetMetaData metaData = resultSet.getMetaData();

                // Iterate through the ResultSet and store data in the Map
                while (resultSet.next()) {
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        String key = metaData.getColumnName(i);
                        int value = resultSet.getInt(i);

                        // Put the data into the Map
                        genreCount.put(key, value);

                    }
                }
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
        return genreCount;
    }

    public void Count(String category, Map<String, Integer> genreCount) {

        // store the updated genre count data in the map
        if (genreCount.containsKey(category)) {
            genreCount.put(category, genreCount.get(category) + 1);
        } else {
            genreCount.put(category, 1);
        }
        // add the genre in the queue that takes up to 10 genres
        if (queue.size() == 10) {
            queue.remove();
        }
        queue.add(category);
    }

    // show the count for each category heard
    public void ShowStatistics(Map<String, Integer> genreCount) {
        System.out.println("Genre count: " + genreCount); // + τα στατιστικα σε γραφιμματα μεσω αλλης κλασης
    }

    // show the history queue
    public Queue<String> ShowHistory() {
        return queue;
    }

    public void setCount( Map<String, Integer> genreCount) {
        this.genreCount = genreCount;
    }
    public static Map<String, Integer> getCount() {
        return genreCount;
    }

    @Override
    public void start(Stage stage) {
        // creation of list for the pie chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        // data insertion from the genreCount map
        for (Map.Entry<String, Integer> entry : genreCount.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }

        // create pie chart
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Genre Statistics");

        // set background color
        chart.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(chart, 600, 400);

        // set scene background color
        scene.setFill(Color.rgb(0, 0, 102 )); // Dark blue background

        stage.setScene(scene);
        stage.setTitle("Pie Chart Example");
        stage.show();
    }

    public static void main(String[] args) {
        // Example genreCount map
        Map<String, Integer> genre = getCount();

        // Launch the JavaFX application
        launch(args);
    }
}

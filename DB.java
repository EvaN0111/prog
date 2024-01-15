package gr.aueb.dmst.ecg.eprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class DB {
    private static Connection con = null;
    public static Connection openConnection() {
        // establish a connection with the database sqlite and handle exceptions
        Connection dbcon = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite error: " + e.getMessage());
            return null;
        }
        try {
            dbcon = DriverManager.getConnection("jdbc:sqlite:UserInput.db");
        } catch (Exception e) {
            System.out.println("Could not make connection with the database");
        }
        return dbcon;
    }
    public static void createTables(Connection con) {
        //create database tables: input , genres, users and playlists
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Input (" +
                               "UserName VARCHAR(255) NOT NULL PRIMARY KEY," +
                               "Password VARCHAR(255) NOT NULL," +
                               "Fullname VARCHAR(255) );");
    
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Genres (" +
                               "UserName VARCHAR(255) NOT NULL," +
                               "Pop INT," +
                               "Rock INT," +
                               "Rap INT," +
                               "Jazz INT," +
                               "HipHop INT," +
                               "Classic INT," +
                               "House INT," +
                               "FOREIGN KEY (UserName) REFERENCES Users(UserName));");
    
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Playlists (" +
                               "playlist_id INTEGER PRIMARY KEY ," +
                               "UserName VARCHAR(255) NOT NULL," +
                               "FOREIGN KEY (UserName) REFERENCES Users(UserName));");
        } catch (SQLException e) {
            throw new RuntimeException("Error creating tables", e);
        }
    }
    
    
    public static void close() throws SQLException {

		try {

			// if connection is (still) open
			if (con != null)
				con.close(); // close the connection to the database to end database session

		} catch (SQLException e) {

			throw new SQLException("Could not close connection with the Database Server: " 
				+ e.getMessage());
		}

	}// end of close

    /**
    * This method checks if the statement is still open and
    * closes it.
    * @param stmt The Statement-type object called stmt.
    */
    public static void closeStatement(Statement stmt) {
        try {
            /* if statement is still open */
            if (stmt != null) {
                stmt.close(); // close the statement
            }
        } catch (SQLException e) {
            System.out.println("Could not close the SQL statement: " + e.getMessage());
        }
    }
    /**
    * This method checks if the statement is still open and
    * closes it.
    * @param rs The ResultSet-type object called rs.
    */

    public static void closeResultSet(ResultSet rs) {
        try {
            /* if ResultSet is still open */
            if (rs != null) {
                rs.close(); // close the ResultSet
            }
        } catch (SQLException e) {
            System.out.println("Could not close the SQL statement: " + e.getMessage());
        }
    }
}

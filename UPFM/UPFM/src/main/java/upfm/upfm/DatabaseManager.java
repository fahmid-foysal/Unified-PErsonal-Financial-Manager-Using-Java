package upfm.upfm;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/UPFM"; // Replace `upfm_db` with your database name
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "Fahmid2024@"; // Replace with your MySQL password

    private Connection connection;

    public DatabaseManager() {
        try {
            // Establish database connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }

public Connection getConnection() {
    try {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Failed to reconnect to the database.");
    }
    return connection;
}


    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to close the database connection.");
        }
    }
}

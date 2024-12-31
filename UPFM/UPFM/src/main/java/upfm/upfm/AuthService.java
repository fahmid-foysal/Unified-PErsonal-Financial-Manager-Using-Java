package upfm.upfm;

import java.sql.*;

public class AuthService {
    private DatabaseManager dbManager;
    boolean istaken = false;

    public AuthService(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    // Register a new user
    public boolean register(String username, String password, String email, String phoneNumber) {
        try {
            // Check if username or email is already taken
            String checkQuery = "SELECT * FROM Users WHERE username = ? OR email = ?";
            try (PreparedStatement checkStmt = dbManager.getConnection().prepareStatement(checkQuery)) {
                checkStmt.setString(1, username);
                checkStmt.setString(2, email);
                ResultSet resultSet = checkStmt.executeQuery();
                if (resultSet.next()) {
                    System.out.println("Username or email is already taken.");
                    istaken = true;
                    return false;
                }
            }

            // Add new user
            String insertQuery = "INSERT INTO Users (username, password, email, phone_number) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertStmt = dbManager.getConnection().prepareStatement(insertQuery)) {
                insertStmt.setString(1, username);
                insertStmt.setString(2, password); // Store plain text only for development; use hashing in production.
                insertStmt.setString(3, email);
                insertStmt.setString(4, phoneNumber);
                insertStmt.executeUpdate();
                System.out.println("Registration successful for username: " + username);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to register user.");
        }
        return false;
    }

    // Login a user
    public User login(String username, String password) {
        try {
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phone_number");
                    User user = new User(username, password, email, phoneNumber);
                    System.out.println("Login successful for username: " + username);
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to log in.");
        }

        System.out.println("Invalid username or password.");
        return null;
    }

    // Check if a user exists
    public boolean isUserExists(String username) {
        try {
            String query = "SELECT * FROM Users WHERE username = ?";
            try (PreparedStatement stmt = dbManager.getConnection().prepareStatement(query)) {
                stmt.setString(1, username);
                ResultSet resultSet = stmt.executeQuery();
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to check if user exists.");
        }
        return false;
    }
    public boolean getistaken(){
        return istaken;
    }
}

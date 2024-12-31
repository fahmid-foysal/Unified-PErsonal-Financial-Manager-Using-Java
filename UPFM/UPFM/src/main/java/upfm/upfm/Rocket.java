/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upfm.upfm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Rocket extends MobileBankingApp {
    public Rocket(String userName, String mobileNumber) {
        super(userName, mobileNumber);
    }

    // Add account method to save data in the database
    public void addAccount(DatabaseManager dbManager) {
        String query = "INSERT INTO Rocket (username, mobile_number) VALUES (?, ?)";

        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, getUserName());
            stmt.setString(2, getMobileNumber());
//            stmt.setDouble(3, getBalance());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Rocket account added successfully to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding Rocket account: " + e.getMessage());
        }
    }

}
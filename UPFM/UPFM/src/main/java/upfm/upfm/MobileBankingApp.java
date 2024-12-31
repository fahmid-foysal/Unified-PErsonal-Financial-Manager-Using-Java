package upfm.upfm;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class MobileBankingApp {
    private String userName;
    private String mobileNumber;
    private double balance;

    public MobileBankingApp(String userName, String mobileNumber) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
//        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

public double getBalance(DatabaseManager dbManager, String mobileNum, String tableName) {
    String query = "SELECT balance FROM " + tableName + " WHERE mobile_number = ?";
    double balance = 0.0; // Default balance value

    try (Connection conn = dbManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, mobileNum); // Set the mobile number

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                balance = rs.getDouble("balance"); // Fetch the balance
            } else {
                System.out.println("No record found for mobile number: " + mobileNum);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error fetching balance: " + e.getMessage());
    }

    return balance; // Return the fetched balance
}

    public void updateBalance(DatabaseManager dbManager, String mobileNum, String tableName, double amount) {
    String query = "UPDATE " + tableName + " SET balance = ? WHERE mobile_number = ?";

    try (Connection conn = dbManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setDouble(1, amount); // Set the new balance
        stmt.setString(2, mobileNum); // Specify the mobile number

        int rowsUpdated = stmt.executeUpdate(); // Execute the update query

        if (rowsUpdated > 0) {
            System.out.println("Balance updated successfully for mobile number: " + mobileNum);
        } else {
            System.out.println("No matching record found for mobile number: " + mobileNum);
        }
    } catch (SQLException e) {
        System.err.println("Error updating balance: " + e.getMessage());
    }
}


    // Deposit money
    public void deposit(double amount, DatabaseManager dbManager, String tableName,String pn) {
        if (amount > 0) {
            balance += amount;
            updateBalanceInDatabase(dbManager, tableName,pn);
            System.out.println("Deposit successful! Amount: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount, DatabaseManager dbManager, String tableName, String pn) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            updateBalanceInDatabase(dbManager, tableName,pn);
            System.out.println("Withdrawal successful! Amount: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Update balance in the database
    private void updateBalanceInDatabase(DatabaseManager dbManager, String tableName, String pn) {
        String query = "UPDATE " + tableName + " SET balance = ? WHERE mobile_number = ?";

        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, balance);
            stmt.setString(2, pn);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Balance updated successfully in the database.");
            } else {
                System.out.println("Failed to update balance in the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating balance: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "MobileBankingApp{" +
                "userName='" + userName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}

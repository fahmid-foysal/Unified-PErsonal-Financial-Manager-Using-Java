package upfm.upfm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccount {
    private String username;
    private String accountNumber;
    private String bankName;
    private double balance;

    public BankAccount(String username) {
        this.username = username;
//        this.accountNumber = accountNumber;
//        this.bankName = bankName;
//        this.balance = balance;
    }



public String getUsername(DatabaseManager dbManager, String AccNum) {
    String query = "SELECT username FROM BankAccs WHERE account_number = ?";  // Check if the column names are correct
    String usernm = ""; // Default username value

    try (Connection conn = dbManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, AccNum); // Set the account number

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                usernm = rs.getString("username"); // Fetch the username
            } else {
                System.out.println("No record found for account number: " + AccNum);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error fetching username: " + e.getMessage());
    }
    System.out.println("fetched :"+usernm);

    return usernm; // Return the fetched username
}


    public String getBankName() {
        return bankName;
    }

public double getBalance(DatabaseManager dbManager, String AccNum) {
    String query = "SELECT balance FROM BankAccs WHERE account_number = ?";
    double balance = 0.0; // Default balance value

    try (Connection conn = dbManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, AccNum); // Set the mobile number

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                balance = rs.getDouble("balance"); // Fetch the balance
            } else {
                System.out.println("No record found for mobile number: " + AccNum);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error fetching balance: " + e.getMessage());
    }

    return balance; // Return the fetched balance
}

    public void updateBalance(DatabaseManager dbManager, String AccNum, double amount) {
    String query = "UPDATE BankAccs SET balance = ? WHERE account_number = ?";

    try (Connection conn = dbManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setDouble(1, amount); // Set the new balance
        stmt.setString(2, AccNum); // Specify the mobile number

        int rowsUpdated = stmt.executeUpdate(); // Execute the update query

        if (rowsUpdated > 0) {
            System.out.println("Balance updated successfully for mobile number: " + AccNum);
        } else {
            System.out.println("No matching record found for mobile number: " + AccNum);
        }
    } catch (SQLException e) {
        System.err.println("Error updating balance: " + e.getMessage());
    }
}

    // Add new account to the database
    public boolean addAccount(DatabaseManager dbManager,String bn, String accNum) {
        String query = "INSERT INTO BankAccs (username, account_number, bank_name) VALUES (?, ?, ?)";
        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username); // Set the username
            stmt.setString(2, accNum); // Set the account number
            stmt.setString(3, bn); // Set the bank name
             // Set the initial balance

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Account added successfully for user: " + username);
                return true;
            } else {
                System.out.println("Failed to add account for user: " + username);
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error adding account to database: " + e.getMessage());
            return false;
        }
    }

    // Deposit money and update database
    public void deposit(double amount, DatabaseManager dbManager) {
        if (amount > 0) {
            balance += amount; // Update balance in memory
            if (updateBalanceInDatabase(dbManager)) {
                System.out.println("Deposit successful! Amount: " + amount + ". New Balance: " + balance);
            } else {
                System.out.println("Deposit failed! Could not update the database.");
            }
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money and update database
    public void withdraw(double amount, DatabaseManager dbManager) {
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Update balance in memory
            if (updateBalanceInDatabase(dbManager)) {
                System.out.println("Withdrawal successful! Amount: " + amount + ". New Balance: " + balance);
            } else {
                System.out.println("Withdrawal failed! Could not update the database.");
            }
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Update balance in the database
    private boolean updateBalanceInDatabase(DatabaseManager dbManager) {
        String query = "UPDATE BankAccs SET balance = ? WHERE account_number = ?";
        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, balance); // Update balance
            stmt.setString(2, accountNumber); // Identify account by account number

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Return true if update was successful
        } catch (SQLException e) {
            System.err.println("Error updating bank account balance: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "username='" + username + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

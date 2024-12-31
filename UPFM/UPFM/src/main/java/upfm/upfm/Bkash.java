package upfm.upfm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bkash extends MobileBankingApp {

    public Bkash(String userName, String mobileNumber) {
        super(userName, mobileNumber);
    }

    // Add account method to save data in the database
    public void addAccount(DatabaseManager dbManager) {
        String query = "INSERT INTO Bkash (username, mobile_number) VALUES (?, ?)";

        try (Connection conn = dbManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, getUserName());
            stmt.setString(2, getMobileNumber());
//            stmt.setDouble(3, getBalance());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Bkash account added successfully to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding Bkash account: " + e.getMessage());
        }
    }



//    public void addMoneyFromBankAccount(BankAccount bankAccount, double amount) {
//        if (amount > 0 && amount <= bankAccount.getBalance()) {
//            bankAccount.withdraw(amount);
//            deposit(amount);
//            System.out.println("Add Money successful! Amount: " + amount + " from Bank Account: " + bankAccount.getAccountNumber());
//        } else {
//            System.out.println("Insufficient balance in the bank account or invalid amount.");
//        }
//    }
}

package upfm.upfm;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password; // For simplicity, storing as plain text (consider encryption in a real system)
    private String email;
    private String phoneNumber;
    private List<BankAccount> bankAccounts;
    private List<MobileBankingApp> mobileBankingApps;

    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bankAccounts = new ArrayList<>();
        this.mobileBankingApps = new ArrayList<>();
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
        public String getPassword() {
        return password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean authenticate(String inputPassword) {
        return password.equals(inputPassword);
    }

    // Manage bank accounts
    public void addBankAccount(BankAccount account) {
        bankAccounts.add(account);
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    // Manage mobile banking apps
    public void addMobileBankingApp(MobileBankingApp app) {
        mobileBankingApps.add(app);
    }

    public List<MobileBankingApp> getMobileBankingApps() {
        return mobileBankingApps;
    }
}
    // Display all accounts
//    public void displayAccounts() {
//        System.out.println("Bank Accounts:");
//        for (BankAccount account : bankAccounts) {
//            System.out.println(account);
//        }
//        System.out.println("\nMobile Banking Apps:");
//        for (MobileBankingApp app : mobileBankingApps) {
//            System.out.println(app.getClass().getSimpleName() + " - Balance: " + app.getBalance());
//        }
//    }
//}

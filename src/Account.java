import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
    public static void viewAccounts(Connection conn, String name) {
        try {
            PreparedStatement stm = conn.prepareStatement(
                    "SELECT accountName, accountType, balance FROM accounts WHERE nameOfOwner=?"
            );
            stm.setString(1, name);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String accountName = rs.getString("accountName");
                String accountType = rs.getString("accountType");
                int balance = rs.getInt("balance");

                System.out.println("Account: " + accountName + ", Type: " + accountType + ", Balance: " + balance);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void viewAccounts(Connection conn, int clientId) {
        try {
            PreparedStatement stm = conn.prepareStatement(
                    "SELECT accountName, accountType, balance FROM accounts WHERE client_id=?"
            );
            stm.setInt(1, clientId);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String accountName = rs.getString("accountName");
                String accountType = rs.getString("accountType");
                int balance = rs.getInt("balance");

                System.out.println("Account: " + accountName + ", Type: " + accountType + ", Balance: " + balance);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static boolean deposit(Connection conn, int clientId, String accountName, int amount) {
        try {
            // 1️⃣ Check if the account exists and get the current balance
            PreparedStatement checkStmt = conn.prepareStatement(
                    "SELECT balance FROM accounts WHERE client_id=? AND accountName=?"
            );
            checkStmt.setInt(1, clientId);
            checkStmt.setString(2, accountName);

            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Account not found!");
                return false;
            }

            int currentBalance = rs.getInt("balance");

            // 2️⃣ Update balance after deposit
            PreparedStatement updateStmt = conn.prepareStatement(
                    "UPDATE accounts SET balance=? WHERE client_id=? AND accountName=?"
            );
            updateStmt.setInt(1, currentBalance + amount);
            updateStmt.setInt(2, clientId);
            updateStmt.setString(3, accountName);

            int rowsAffected = updateStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Deposit successful! New balance: " + (currentBalance + amount));
                return true;
            } else {
                System.out.println("Failed to update balance.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public static void checkBalance(Connection conn, int clientId, String accountName) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT balance FROM accounts WHERE client_id=? AND accountName=?"
            );
            stmt.setInt(1, clientId);
            stmt.setString(2, accountName);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int balance = rs.getInt("balance");
                System.out.println("Account: " + accountName + " | Current balance: " + balance);
            } else {
                System.out.println("Account not found!");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


}

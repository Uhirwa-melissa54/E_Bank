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
}

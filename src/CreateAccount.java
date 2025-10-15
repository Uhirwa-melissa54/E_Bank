import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccount {
    public  static int createAccount(Connection conn, int id, String name, String accoutName, String accountType, int balance){
        try {
            PreparedStatement stm1 = conn.prepareStatement("INSERT INTO accounts(id,nameOfOwner,accountName,accountType,balance) values(?,?,?,?,?)");
            stm1.setInt(1,id);
            stm1.setString(2,name);
            stm1.setString(3,accoutName);
            stm1.setString(4,accountType);
            stm1.setInt(5,balance);
            int rows=stm1.executeUpdate();
            return rows;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }

    }

}

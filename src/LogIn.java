import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogIn {
    public static boolean check(Connection conn,String name,String password){
        try{
            PreparedStatement stm1=conn.prepareStatement("SELECT * FROM  clients where name=? and password =?");
            String hashedPassword=PasswordUtil.hashPassword(password);
            stm1.setString(1,name);
            stm1.setString(2,hashedPassword);
            ResultSet rs= stm1.executeQuery();

            if (rs.next()) {
                return true;
            } else {


                return false;
            }

        }
        catch(SQLException e){
            System.out.println(e);
            return false;
        }

    }
}

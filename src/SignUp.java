

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUp{
public static int create(Connection conn, String name, String email, String location, String password){
    try {
        PreparedStatement stm1 = conn.prepareStatement("INSERT INTO clients (name,email,location,password) values(?,?,?,?)");
        String hashedPassword = PasswordUtil.hashPassword(password);
        stm1.setString(1,name);
        stm1.setString(2,email);
        stm1.setString(3,location);
        stm1.setString(4,hashedPassword);

        int rows= stm1.executeUpdate();
        return rows;
    }
    catch(SQLException e){
        System.out.println(e);
        return -1;
    }

}

}

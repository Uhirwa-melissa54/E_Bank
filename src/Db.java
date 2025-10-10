import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    public static Connection dbConnect(){
        String url = System.getenv("db_url");
        String user = System.getenv("db_user");
        String pass = System.getenv("db_pass");
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {


    public static Connection dbConnectClients(){
        String url = System.getenv("db_url_clients");
        String user = System.getenv("db_user");
        String pass = System.getenv("db_pass");


        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Database connectivity");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }



        }

    }




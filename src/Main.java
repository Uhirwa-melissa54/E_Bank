import java.sql.Connection;

public class Main{
    public static void main(String[] args){
        Connection conn=Db.dbConnectClients();
        CreateAccount.createAccount(conn,1,"Melissa","account1","SavingAccount",5000);

    }
}
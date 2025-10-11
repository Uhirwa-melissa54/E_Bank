import java.sql.Connection;

public class Main{
    public static void main(String[] args){
        Connection conn=Db.dbConnect();
        int returnedRow=SignUp.create(conn,"Bonnette Umurerwa","umubonnie@gmail.com","Kigali","What54.");




    }
}
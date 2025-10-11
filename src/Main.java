import java.sql.Connection;

public class Main{
    public static void main(String[] args){
        Connection conn=Db.dbConnect();
        int returnedRow=SignUp.create(conn,"Bonnette Umurerwa","umubonnie@gmail.com","Kigali","What54.");
        boolean whatIsIt=LogIn.check(conn,"Bonnette Umurerwa","What54.");
        if(whatIsIt){
            System.out.println("User exits");
        }
        else{
            System.out.println("What fuck do you think you are doing");
        }




    }
}
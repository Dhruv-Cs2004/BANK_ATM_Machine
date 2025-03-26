import java.sql.*;

public class Con {
    Connection c;
    Statement s;
    public Con(){
        try {
            c=DriverManager.getConnection("jdbc:mysql:///BankManagementSystem","root","Sonia1978");
            s=c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

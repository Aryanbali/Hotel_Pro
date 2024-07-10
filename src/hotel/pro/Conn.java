package hotel.pro;
import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelpro", "root", "Expert123");
            s = c.createStatement();           //used for executing query
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Conn();
        System.out.println("Connection Successfull");
    }
}



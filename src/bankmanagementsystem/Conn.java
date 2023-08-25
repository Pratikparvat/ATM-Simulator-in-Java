package bankmanagementsystem;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement st;
    
    public Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementSystem","root","root");
        st = c.createStatement();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}



package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    JButton exit;
    
    MiniStatement(String pinnumber){
        setTitle("MINI STATEMENT");
        setLayout(null);
         getContentPane().setBackground(Color.WHITE);
         
        JLabel l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);
        add(l1);
        
        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);
         
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(20, 500, 100, 25);
        add(exit);
        
     
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}
        
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.st.executeQuery("SELECT * FROM bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+ balance);
        }catch(Exception e){
            e.printStackTrace();
        }
         
        setSize(400,600);
        setLocation(20,20);

        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String args[]){
        new MiniStatement(""); 
    }    
    
}

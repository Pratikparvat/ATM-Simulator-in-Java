
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawal extends JFrame implements ActionListener{
    
    JButton Withdraw,back;
    JTextField amount;
    String pinnumber;
    
    Withdrawal(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add((text));
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD, 22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(355,485,150,30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);         
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == Withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
            }else{
                try{
                Conn con = new Conn();
                String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawal', '"+ number +"')";
                con.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + number + " withdraw Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    e.getMessage();
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new Withdrawal("");
    }
}

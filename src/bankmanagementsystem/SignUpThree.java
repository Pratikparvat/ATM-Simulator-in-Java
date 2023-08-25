
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{   
  
    JRadioButton r1,r2,r3,r4;
    JButton submit,cancel;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    
    SignUpThree(String formno){
        
        this.formno = formno;
        setTitle("Account Details- PAGE 3");     
        
        JLabel text = new JLabel("Page 3: Account Details");
        text.setFont(new Font("Raleway", Font.BOLD, 22));
        text.setBounds(280,40,400,40);
        add(text); 
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,30);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,300,30);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,30);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,30);
        add(r4);
        
        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(r1);
        accgroup.add(r2);
        accgroup.add(r3);
        accgroup.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel cardnumber = new JLabel("XXXX-XXXX-XXXX-4184");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        cardnumber.setBounds(330,300,250,30);
        add(cardnumber);
        
        JLabel carddetail = new JLabel("(Your 16-digit Card number)");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100,330,200,20);
        add(carddetail);   
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pinnumber.setBounds(330,370,200,30);
        add(pinnumber);
    
        JLabel pindetail = new JLabel("(4-digit password)");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100,400,200,20);
        add(pindetail); 
        
        JLabel l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(700,10,70,30);
        add(l11);
        
        JLabel l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(770,10,40,30);
        add(l12);    
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100,450,200,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,500,200,30);
        add(c2);        
       
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,550,200,30);
        add(c4);     
               
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,600,200,30);
        add(c6);    
             
        c7 = new JCheckBox("I hereby declares that the above entered details are correct and can be verified.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100,680,600,20);
        add(c7);         
        

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel); 
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(500,120);
        setVisible(true);         
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit)
        {
        String acctype = null;
        if(r1.isSelected()){ 
            acctype = "Saving Account";
        }
        else if(r2.isSelected()){ 
            acctype = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){ 
            acctype = "Current Account";
        }
        else if(r4.isSelected()){ 
            acctype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        String services = "";
        if(c1.isSelected()){ 
            services = services + " ATM Card";
        }
        if(c2.isSelected()){ 
            services = services + " Internet Banking";
        }
        if(c3.isSelected()){ 
            services = services + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            services = services + " EMAIL Alerts";
        }
        if(c5.isSelected()){ 
            services = services + " Cheque Book";
        }
        if(c6.isSelected()){ 
            services = services + " E-Statement";
        }
        
        try{
            if(acctype.equals("")){
                JOptionPane.showMessageDialog(null,"Account type is required");
            }else
            {
            Conn con = new Conn();
            String query1 = "insert into signupthree values('"+formno+"','"+acctype+"','"+cardno+"','"+pin+"','"+services+"')";  
            String query2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
            con.st.executeUpdate(query1);
            con.st.executeUpdate(query2);
            
            
            JOptionPane.showMessageDialog(null,"CardNumber " + cardno + "\nPin: "+ pin + "\nPLease note it down..");  
            
            setVisible(false);
            new Deposit(pin).setVisible(true);
            
        }
        }catch(Exception e){
            System.out.println(e);
        }
        
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
        
            
        
        
    }
    
    public static void main(String[] args){
        new SignUpThree("").setVisible(true);
    }
    
}



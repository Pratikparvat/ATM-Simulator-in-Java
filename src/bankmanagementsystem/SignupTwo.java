package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
   
    JTextField   panTextField, OccupationTextField, adharTextField;
    String formNo;
    JButton next;
    JRadioButton accNo,seniorYes,seniorNo,accYes;
    JComboBox incomeVal,nation, eduQualification;
    
    SignupTwo(String formNo){
        this.formNo = formNo;
        
        setLayout(null);
        
        setTitle("Page-2");
        
       
//        JLabel formno = new JLabel("APPLICATION FORM NO." + random);
//        formno.setFont(new Font("Raleway",Font.BOLD,38));
//        formno.setBounds(140,20,700,40);
//        add(formno); 
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails); 
        
        JLabel nationality = new JLabel("Nationality:");
        nationality.setFont(new Font("Raleway",Font.BOLD,22));
        nationality.setBounds(100,140,200,30);
        add(nationality);
        
        String nationVal[] = {"Indian","NRI"};
        nation = new JComboBox(nationVal);
        nation.setBounds(300, 140, 400, 30);
        nation.setBackground(Color.WHITE);
        add(nation);             
      
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,200,30);
        add(income);
        
        String incomeCategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        incomeVal = new JComboBox(incomeCategory);
        incomeVal.setBounds(300, 240, 400, 30);
        incomeVal.setBackground(Color.WHITE);
        add(incomeVal);        
            
                
        JLabel education = new JLabel("Educational:");
        education.setFont(new Font("Raleway",Font.BOLD,22));
        education.setBounds(100,290,200,30);
        add(education);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,320,200,30);
        add(qualification);
        
        String edCategory[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        eduQualification = new JComboBox(edCategory);
        eduQualification.setBounds(300, 315, 400, 30);
        eduQualification.setBackground(Color.WHITE);
        add(eduQualification);  
       
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,390,200,30);
        add(occupation);  
        
        OccupationTextField = new JTextField();
        OccupationTextField.setFont(new Font("Raleway",Font.BOLD,14));
        OccupationTextField.setBounds(300, 390, 400, 30);
        add(OccupationTextField);
        
        JLabel pan = new JLabel("PAN No.:");
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        JLabel adhar = new JLabel("Adhar No.:");
        adhar.setFont(new Font("Raleway",Font.BOLD,22));
        adhar.setBounds(100,490,200,30);
        add(adhar);
        
        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adharTextField.setBounds(300, 490, 400, 30);
        add(adharTextField);      
        
        
        JLabel citizen = new JLabel("Senoir Cetizen:");
        citizen.setFont(new Font("Raleway",Font.BOLD,22));
        citizen.setBounds(100,540,200,30);
        add(citizen);
        
        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300,540,100,30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);
        
        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(450,540,120,30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);        
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(seniorYes);
        citizengroup.add(seniorNo);       
        
        
        
        JLabel account = new JLabel("Existing account:");
        account.setFont(new Font("Raleway",Font.BOLD,20));
        account.setBounds(100,590,300,30);
        add(account);
        
        accYes = new JRadioButton("Yes");
        accYes.setBounds(300,590,100,30);
        accYes.setBackground(Color.WHITE);
        add(accYes);
        
        accNo = new JRadioButton("No");
        accNo.setBounds(450,590,120,30);
        accNo.setBackground(Color.WHITE);
        add(accNo);        
        
        ButtonGroup Accgroup = new ButtonGroup();
        Accgroup.add(accYes);
        Accgroup.add(accNo); 
        
        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + formNo;
        String national = (String) nation.getSelectedItem();
        String sincome = (String) incomeVal.getSelectedItem();
        String sEducation = (String) eduQualification.getSelectedItem();
        String sOccupation = OccupationTextField.getText();
        String seniorCitizen = null;
        if(seniorYes.isSelected()){
            seniorCitizen = "Yes";
        } else if (seniorNo.isSelected()){
            seniorCitizen = "No";
        }        
      
        String existingAccount = null;
        if(accYes.isSelected()){
            existingAccount = "Yes";
        } else if(accNo.isSelected()){
            existingAccount = "No";       
        }        
        String sPan = panTextField.getText();
        String sAdhar = adharTextField.getText();
       
        
        try{           
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+ formno + "','" + national + "','" + sincome +"','" + sEducation +"','" + sOccupation +"','"+ sPan + "','" + sAdhar + "','"+ seniorCitizen + "','"+ existingAccount + "')";
                c.st.executeUpdate(query);
                
                //signUpThree object for getting form no
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
                
            }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
    
}

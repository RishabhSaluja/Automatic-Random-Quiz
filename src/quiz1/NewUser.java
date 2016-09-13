package quiz1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class NewUser extends JFrame
{
    //Declaring Function Variables
    JFrame nf;
    JPasswordField np1, np2;
    JTextField nt1, nt2, nt3, nt4;
    JLabel nl, nl1, nl2, nl3, nl4, nl5, nl6, nl7;
    JButton nb1, nb2;
    
    //Constructor
    public NewUser()
    {
        
        //Creating Objects For Variables
        nf=new JFrame("Sign Up");
        
        nl=new JLabel("NEW USER ");
        nl.setBounds(230,0,80,30);
        
        nl1=new JLabel("First Name: ");
        nl1.setBounds(30,50,90,30);
        nt1=new JTextField(40);
        nt1.setBounds(165,52,180,30);
        
        nl2=new JLabel("Last Name: ");
        nl2.setBounds(30,90,90,30);
        nt2=new JTextField(40);
        nt2.setBounds(165,92,180,30);
        
        nl3=new JLabel("Roll Number: ");
        nl3.setBounds(30,130,110,30);
        nt3=new JTextField(40);
        nt3.setBounds(165,132,180,30);
        
        nl4=new JLabel("Semester: ");
        nl4.setBounds(30,170,90,30);
        nt4=new JTextField(40);
        nt4.setBounds(165,172,180,30);
        
        nl5=new JLabel("Password: ");
        nl5.setBounds(30,210,90,30);
        np1=new JPasswordField(40);
        np1.setBounds(165,212,180,30);
        
        nl6=new JLabel("Confirm Password: ");
        nl6.setBounds(30,250,150,30);
        np2=new JPasswordField(40);
        np2.setBounds(165,252,180,30);
        
        nl7=new JLabel("GURU NANAK DEV UNIVERSITY");
        nl7.setBounds(0,350,210,35);
        
        nb1=new JButton("SUBMIT");
        nb1.setBounds(330,350,90,35);
        
        nb1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
            {   
                
                try
                {
                   String Query="Insert into login (first,last,roll,sem,pass) values(?,?,?,?,?)";
                   Class.forName("org.sqlite.JDBC");
                   Connection conn=DriverManager.getConnection("jdbc:sqlite://home//rishabh//NetBeansProjects//quiz1//login.db");
                   PreparedStatement pst=conn.prepareStatement(Query);
                   
                   pst.setString(1,nt1.getText());
                   pst.setString(2,nt2.getText());
                   pst.setString(3,nt3.getText());
                   pst.setString(4,nt4.getText());
                   pst.setString(5,np1.getText());
                   
                   JOptionPane.showMessageDialog(null,"Id is Created");
                   JOptionPane.showMessageDialog(null,"Your Roll No. Is Your User-Id");
               
                   pst.execute();
                   pst.close();
                   nf.dispose();
                   new Login();
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                } 
            }});
        
        nb2=new JButton("ABORT");
        nb2.setBounds(430,350,80,35);
        
        nb2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
            {
                nf.dispose(); 
            }});
        
        //Adding Objects to Frame of class NewUser
        nf.add(nl);
        nf.add(nl1);
        nf.add(nt1);
        
        nf.add(nl2);
        nf.add(nt2);
        
        nf.add(nl3);
        nf.add(nt3);
        
        nf.add(nl4);
        nf.add(nt4);
        
        nf.add(nl5);
        nf.add(np1);
        
        nf.add(nl6);
        nf.add(np2);
        
        nf.add(nl7);
        
        nf.add(nb1);
        
        nf.add(nb2);
        
        nf.setLayout(null);
        nf.setSize(530,430);
        nf.setVisible(true);
        nf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
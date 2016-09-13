package quiz1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame 
{   
    //Declaring Function Variables
    JFrame lf;
    JPanel lp1;
    JLabel ll1, ll2, ll3, ll4,ll5;
    JComboBox lc;
    JPasswordField lp;
    JTextField lt1;
    JButton lb1, lb2;
        
    //Constructor
    public Login()
    {
        //Creating Objects For Variables
        lf=new JFrame("Start");
        
        lp1=new JPanel();
        
        ll1=new JLabel("LOGIN");
        ll1.setBounds(330,0,50,80);
        
        ll2=new JLabel("  User_Id  ");
        
        lt1=new JTextField(15);
        
        lc=new JComboBox();
        lc.addItem("Student");
        lc.addItem("Admin");
        
        
        ll3=new JLabel("Password ");
        
        lp=new JPasswordField(15);
        
        ll4=new JLabel();
        ll4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz1/Guru_Nanak_Dev_University_logo.jpg")));
        ll4.setBounds(5,80,277,231);
         
        ll5=new JLabel("GURU NANAK DEV UNIVERSITY");
        ll5.setBounds(5,320,220,35);
        
        lb1=new JButton("Login");
        
        lb2=new JButton("Abort");
        
        lp1.add(ll2);
        lp1.add(lt1);
        lp1.add(ll3);
        lp1.add(lp);
        lp1.add(lc);
        lp1.add(lb1);
        lp1.add(lb2);
        
        lp1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        lp1.setSize(300,120);
        lp1.setLocation(400,100);
        lp1.setBackground(Color.yellow);
        
        lf.add(lp1);
        lf.add(ll4);
        lf.add(ll5);
        
        //Adding Objects to Frame of class Login
        lf.add(ll1);
        
            lb1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
            {   
            if(lc.getSelectedItem()=="Student")
            {
                try
                {
                   String id;
                   String Query="Select * from login where roll=? and pass=?";
                   Class.forName("org.sqlite.JDBC");
                   Connection conn=DriverManager.getConnection("jdbc:sqlite://home//rishabh//NetBeansProjects//quiz1//login.db");
                   PreparedStatement pst=conn.prepareStatement(Query);
                   
                   pst.setString(1,lt1.getText());
                   pst.setString(2,lp.getText());
                   
                   ResultSet rs=pst.executeQuery();
                   if(rs.next())
                   {
                   lf.dispose();
                   JOptionPane.showMessageDialog(null,"Login Successfull");
                   id=lt1.getText();
                   rs.close();
                   pst.close();
                   Questions q=new Questions(id);                     
                   }
                   else
                   {
                      JOptionPane.showMessageDialog(null,"User-Id or Password is InCorrect");
                   rs.close();
                   pst.close();
                   }

                }
                catch(Exception e)
                {
                    //System.out.println("Java:"+e);
                    JOptionPane.showMessageDialog(null,e);
                }
            }
               
                else if(lc.getSelectedItem()=="Admin")
                {
                try
                {
                   String Query="Select * from master where id=? and Password=?";
                   Class.forName("org.sqlite.JDBC");
                   Connection conn=DriverManager.getConnection("jdbc:sqlite://home//rishabh//NetBeansProjects//quiz1//master.db");
                   PreparedStatement pst=conn.prepareStatement(Query);
                   
                   pst.setString(1,lt1.getText());
                   pst.setString(2,lp.getText());
                   ResultSet rs=pst.executeQuery();
                   
                   if(rs.next())
                   {
                   lf.dispose();
                   JOptionPane.showMessageDialog(null,"Login Successfull"); 
                   NewUser k=new NewUser();
                   }
                   
                   else
                   
                   {
                      JOptionPane.showMessageDialog(null,"User-Id or Password is InCorrect");
                   }
                   rs.close();
                   pst.close();

                }
                
                catch(Exception e)
                {
                    //System.out.println("Java:"+e);
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            }
            });
            
        lb2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {   
            lf.dispose();
        }});


        lf.setLayout(null);
        lf.setSize(750,400);
        lf.setVisible(true);
        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
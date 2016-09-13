package quiz1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class start extends JFrame
{
    //Creating Objects For Variables
    JFrame sf;
    JLabel sl1,sl2,sl3;
    JRadioButton sr1,sr2;
    JButton sb1,sb2;
    ButtonGroup sg=new ButtonGroup();

    //Constructor
    public start()
    {
        sf=new JFrame("Start");
        
        sl1=new JLabel("Welcome");
        sl1.setBounds(280,20,80,30);
    
        sr1=new JRadioButton("New User");
        sr1.setBounds(330,100,150,50);
    
        sr2=new JRadioButton("Exiting User");
        sr2.setBounds(330,150,150,50);
    
        sl2=new JLabel("GURU NANAK DEV UNIVERSITY");
        sl2.setBounds(20,320,250,30);
    
        sb1=new JButton("OK");
        sb1.setBounds(320,300,80,40);
        
        sl3=new JLabel();
        sl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz1/Guru_Nanak_Dev_University_logo.jpg")));
        sl3.setBounds(5,60,277,231);
        
        sb1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {   
            if(sr1.isSelected())
            {
                new NewUser();
                sf.dispose();
            }
            else if(sr2.isSelected())
            {
                new Login();
                sf.dispose();
            }
        }});
        
        sb2=new JButton("ABORT");
        sb2.setBounds(420,300,80,40);

        sb2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {   
            sf.dispose();
        }});
        
        sg.add(sr1);
        sg.add(sr2);

        sf.add(sl1);
        sf.add(sr1);
        sf.add(sr2);
        sf.add(sl2);
        sf.add(sl3);
        sf.add(sb1);
        sf.add(sb2);

        sf.setLayout(null);
        sf.setSize(600,400);
        sf.setVisible(true);
        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
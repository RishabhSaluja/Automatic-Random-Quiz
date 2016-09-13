package quiz1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Settings extends JFrame
{
    JFrame sf;
    JPanel sp;
    JLabel sl1, sl2, sl3, sl4, sl5, sl6, sl7;
    JTextField st1, st2, st3, st4, st5, st6, st7;
    JButton sb1,sb2;
    
    public Settings()
    {
        sf=new JFrame("Settings");
        
        sp=new JPanel();
        
        sl1=new JLabel("Number Of Questions In Database");
        st1=new JTextField(15);
        sl2=new JLabel("Number Of Questions In Test          ");
        st2=new JTextField(15);
        sl3=new JLabel("Number Of Hours In Test                 ");
        st3=new JTextField(15);
        sl4=new JLabel("Number Of Minutes In Test             ");
        st4=new JTextField(15);
        sl5=new JLabel("Number Of Seconds In Test            ");
        st5=new JTextField(15);
        sl6=new JLabel("Score Display                                   ");
        st6=new JTextField(15);
        sl7=new JLabel("Total Marks                                      ");
        st7=new JTextField(15);
        
        sb1=new JButton("SAVE");
        sb2=new JButton("SET DEFAULT");
        
        sp.add(sl1);
        sp.add(st1);
        sp.add(sl2);
        sp.add(st2);
        sp.add(sl3);
        sp.add(st3);
        sp.add(sl4);
        sp.add(st4);
        sp.add(sl5);
        sp.add(st5);
        sp.add(sl6);
        sp.add(st6);
        sp.add(sl7);
        sp.add(st7);
        sp.add(sb1);
        sp.add(sb2);
        
        sp.setSize(450,300);
        sp.setLocation(10,10);
        
        sf.add(sp);
        
        sf.setLayout(null);
        sf.setSize(700,450);
        sf.setVisible(true);
        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
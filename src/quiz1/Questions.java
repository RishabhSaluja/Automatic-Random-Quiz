package quiz1;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.event.*;


public class Questions
{
    int count=2, sec=count*60;
    static Timer timer = new Timer();;
    
    HashMap<Integer,String> h=new HashMap<>();
    HashMap<Integer,Integer> map=new HashMap<>();
    HashMap<Integer,String> res=new HashMap<>();
    
    JFrame qf;
    JRadioButton qr1;
    JRadioButton qr2, qr3, qr4, qr5;
    JButton qb1, qb2,qb3;
    JList qjl;
    JPanel qp1, qp2;
    JLabel ql0, ql1, ql2, ql3;
    int s=0,index,l,c=0;
    String a;
    ButtonGroup qg=new ButtonGroup();
    
    
    public String getSelection(){
                        String selectedChoice=null;
                        Enumeration<AbstractButton> buttons=qg.getElements(); 
                        while(buttons.hasMoreElements()) 
                        { 
                        JRadioButton temp=(JRadioButton)buttons.nextElement(); 
                        if(temp.isSelected()) 
                                    { 
                                                selectedChoice=temp.getText();
                                    } 
                         }  
                        return(selectedChoice);
            }
    
    private String TimeFormat(int sec1) {

        int seconds = sec1%60;
        int minutes = sec1/60;
        int hours = sec1/3600;
        
        if (sec1 <= 0)
        {
            timer.cancel();
            qb3.doClick();
        }
        
        return String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);
    }
    
    public Questions(String id)
    {  
        timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            if(sec==60)
            {
                ql3.setForeground(Color.RED);
            }
            
            ql3.setText(TimeFormat(sec));
            sec--;
            
        }},1000,1000);

        //Creating Objects For Variables
        qf=new JFrame("TEST");
        qp1=new JPanel();
        qp2=new JPanel();
      //  Vector listVector = new Vector() ;
        
        ql0=new JLabel();
        ql0.setBounds(0,0,80,30);
        
        ql1=new JLabel();
        ql1.setBounds(15,0,1000,30);
                       
        qr1=new JRadioButton("", false);
        qr1.setBounds(45,50,450,30);
        
        qr2=new JRadioButton("", false);
        qr2.setBounds(45,90,450,30);
        
        qr3=new JRadioButton("", false);
        qr3.setBounds(45,130,450,30);
        
        qr4=new JRadioButton("", false);
        qr4.setBounds(45,170,450,30);
        
        qr5=new JRadioButton();
        //qr5.setBounds(45,200,450,30);
        
        ql2=new JLabel("GURU NANAK DEV UNIVERSITY");
        ql2.setBounds(0,300,250,30);
        
        ql3=new JLabel();
        
        qb1=new JButton("MARK OPTION");
        qb1.setBounds(5,250,150,30);
        
        qb2=new JButton("UNMARK ALL");
        qb2.setBounds(160,250,150,30);
        
        qb3=new JButton("FINISH");
        qb3.setBounds(580,300,150,30);
        
        DefaultListModel mod=new DefaultListModel();
        qjl=new JList();
        
                   int c=0;
                   Random r =new Random();
                   int k[]=new int[10];
                   c=0;
                       while(c<10)
                       {
                           k[c]=r.nextInt(40);
                           if(k[c]==0)
                           {
                               k[c]=k[c]+1;
                           }
                           c++;
                       }
                       for(c=0;c<10;c++)
                       {
                       for(int j=c+1;j<10;j++)
                       {   
                           while(k[c]==k[j])
                               {
                                   k[j]=r.nextInt(40);
                               }
                       } 
                        mod.addElement("Question "+(c+1));
                        qjl.setModel(mod);
                       }
                       
                       for(c=0;c<10;c++)
                       {
                            System.out.println(k[c]);
                       }
                       
                        qjl.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt)
                       {
                           try
                           {
                                index = qjl.getSelectedIndex();
                                Class.forName("org.sqlite.JDBC");
                                String Query="Select * from questions where id="+k[index];
                                Connection conn=DriverManager.getConnection("jdbc:sqlite://home//rishabh//NetBeansProjects//quiz1//questionare.db");
                                PreparedStatement pst=conn.prepareStatement(Query);
                                ResultSet rs=pst.executeQuery();
                                if(rs.next())
                                {
                                    ql0.setText(rs.getString("id"));
                                    ql1.setText(rs.getString("question"));
                                    qr1.setText(rs.getString("option1"));
                                    qr2.setText(rs.getString("option2"));
                                    qr3.setText(rs.getString("option3"));
                                    qr4.setText(rs.getString("option4"));
                                    qr5.setText(rs.getString("answer"));
                                    a=qr5.getText();
                                    
                                    l=index;
                                    
                                    if(map.get(l)!=null)
                                {
                                    switch(map.get(l))
                                        {
                                            case 1:
                                                qr1.setSelected(true);
                                                break;
                                            case 2:
                                                qr2.setSelected(true);
                                                break;
                                            case 3:
                                                qr3.setSelected(true);
                                                break;
                                            case 4:
                                                qr4.setSelected(true);
                                                break;
                                            default:
                                                break;
                                        }
                                }
                                    
                                    if(map.get(l)==null)
                                        {
                                    qg.clearSelection();
                                        }
                                    System.out.println(h.get(l)+" 1st");
                                    }
                                rs.close();
                                pst.close();

                                
                                
                           }
                           catch(Exception ee)
                           {
                            //System.out.println("Java:"+e);
                            JOptionPane.showMessageDialog(null,"dee");
                           }
                           }
                           });
                            
                                    qb1.addActionListener(new ActionListener()
                                    {
                                    public void actionPerformed(ActionEvent ae)
                                    {
                                        if(qg.getSelection()!=null)
                                        {
                                            
                                            if(qr1.isSelected())
                                            {map.put(l,1);
                                            System.out.println(map.get(l));}
                                            else
                                            if(qr2.isSelected())
                                            {map.put(l,2);
                                            System.out.println(map.get(l));}
                                            else
                                            if(qr3.isSelected())
                                            {map.put(l,3);
                                            System.out.println(map.get(l));}
                                            else
                                            if(qr4.isSelected())
                                            {map.put(l,4);
                                            System.out.println(map.get(l));}
                                            
                                            System.out.println(index);
                                        if(h.get(l)!=null||h.get(l)==null)
                                        {    
                                        switch(map.get(l))
                                        {
                                            case 1:
                                                qr1.setSelected(true);
                                                h.put(l, qr1.getText());
                                                break;
                                            case 2:
                                                qr2.setSelected(true);
                                                h.put(l, qr2.getText());
                                                break;
                                            case 3:
                                                qr3.setSelected(true);
                                                h.put(l, qr3.getText());
                                                break;
                                            case 4:
                                                qr4.setSelected(true);
                                                h.put(l, qr4.getText());
                                                break;
                                            default:
                                                break;
                                        }
                                        
                                        if(h.get(l).equals(a))
                                                   {
                                                       System.out.println(index+"righ");
                                                       System.out.println("AA");
                                                       
                                                       if(res.get(l)=="false" && res.get(l)!=null)
                                                       res.replace(l,"false","true");
                                                       else
                                                       res.put(l,"true");
                                                       
                                                   }
                                                   else
                                                   {
                                                       System.out.println(index+" wro");
                                                       System.out.println("B");
                                                       if(res.get(l)=="true" && res.get(l)!=null)
                                                       res.replace(l,"true","false");
                                                       else
                                                       res.put(l,"false");
                                                   }
                                        
                                        }
                                    }
                                        else if(qg.getSelection()==null)
                                        System.out.println("Select option ");
                                    }
                                    });
    
     
    
    qb3.addActionListener(new ActionListener()
    {
                public void actionPerformed(ActionEvent ae)
            {
                
                try
                {
                   
                int val=0;
                s=0;
                while(val<10)
                {
                    if(res.get(val)!=null)
                    {        
                    if(res.get(val).equals("true"))
                    s++;
                    else
                    s=s+0;
                    }
                val++;
                }
                   
                JOptionPane.showMessageDialog(null,"Score="+s);
                qf.dispose();
                   String Query1="Update login set score="+s+" where roll='"+id+"'";
                   Class.forName("org.sqlite.JDBC");
                   Connection conn=DriverManager.getConnection("jdbc:sqlite://home//rishabh//NetBeansProjects//quiz1//login.db");
                   PreparedStatement pst=conn.prepareStatement(Query1);
                   
                   ResultSet rs=pst.executeQuery();
                   rs.close();
                   pst.close();
                   
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }   
            }
            });
    
                                  
                                    
    qb2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
            {
               qg.clearSelection();
            }
            });

    
    
        qp1.setSize(180,200);
        qp1.setLocation(550,70);
        qp1.add(qjl);
        
        qp2.setSize(100,40);
        qp2.setLocation(590,30);  
        
        qp2.setBorder(javax.swing.BorderFactory.createTitledBorder("Timer")); 
        qp2.add(ql3);
        
        qp1.add(new JScrollPane(qjl));
        qf.add(qp1);
        qf.add(qp2);
        qg.add(qr1);
        qg.add(qr2);
        qg.add(qr3);
        qg.add(qr4);
        
        qf.add(ql1);
        qf.add(qr1);
        qf.add(qr2);
        qf.add(qr3);
        qf.add(qr4);
        qf.add(qr5);
        
        qf.add(ql2);
        qf.add(qb1);
        qf.add(qb2);
        qf.add(qb3);
        
        qf.setLayout(null);
        qf.setSize(1000,400);
        qf.setVisible(true);
        qf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}
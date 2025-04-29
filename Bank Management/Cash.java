import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class Cash extends JFrame  implements ActionListener{


    JLabel text;
    JButton b1,b2,b3,b4,b5,b6,back;
   String pinnumber;
   String cardnumber;
    Cash(String pinnumber,String cardnumber){
        this.cardnumber=cardnumber;
       
        setLayout(null);

       ImageIcon icon1=new ImageIcon("atm.jpg");
       Image icon2=icon1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon icon3= new ImageIcon(icon2);
       JLabel image= new JLabel(icon3);
       image.setBounds(0,0,900,900);
       add(image);

       text= new JLabel("Select withdrawl amount");
       text.setBounds(220,300,700,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);


       b1= new JButton("Rs 100");
       b1.setBounds(170,415,100,30);
       b1.addActionListener(this);
       image.add(b1);


       b2= new JButton("Rs 500");
       b2.setBounds(360,415,150,30);
       b2.addActionListener(this);
       image.add(b2);

       b3= new JButton("Rs 1000");
       b3.setBounds(170,450,100,30);
       b3.addActionListener(this);
       image.add(b3);

       b4= new JButton("Rs 2000");
       b4.setBounds(360,450,150,30);
       b4.addActionListener(this);
       image.add(b4);

       b5= new JButton("Rs 5000");
       b5.setBounds(170,485,100,30);
       b5.addActionListener(this);
       image.add(b5);

       b6= new JButton("Rs 50000");
       b6.setBounds(360,485,150,30);
       b6.addActionListener(this);
       image.add(b6);

       back= new JButton("Back");
       back.setBounds(360,520,150,30);
       back.addActionListener(this);
       image.add(back);


       
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transactions( pinnumber, cardnumber).setVisible(true);
        } else{
            String amount= ((JButton)e.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where accountNumber='"+cardnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource() != back && balance< Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return ;
                }
                Date date=new  Date();
                String query="insert into bank values('"+cardnumber+"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                 setVisible(true);
                 new Transactions(pinnumber,cardnumber).setVisible(true);
            }catch(Exception ae){
                System.out.println(ae);
            }
        }
           
        }
       

    }
    


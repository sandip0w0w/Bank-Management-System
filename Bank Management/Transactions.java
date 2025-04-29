import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Transactions extends JFrame  implements ActionListener{

    JLabel text;
    JButton deposit,withdrawl,cash,statement,pin_change,balance,exit;
   String pinnumber;
   String cardnumber;
    Transactions(String pinnumber,String cardnumber){
        this.pinnumber=pinnumber;
        this.cardnumber=cardnumber;
        setLayout(null);

       ImageIcon icon1=new ImageIcon("atm.jpg");
       Image icon2=icon1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon icon3= new ImageIcon(icon2);
       JLabel image= new JLabel(icon3);
       image.setBounds(0,0,900,900);
       add(image);

       text= new JLabel("Please select your Transaction");
       text.setBounds(220,300,700,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);


       deposit= new JButton("Deposit");
       deposit.setBounds(170,415,100,30);
       deposit.addActionListener(this);
       image.add(deposit);


       withdrawl= new JButton("Cash Withdrawl");
       withdrawl.setBounds(360,415,150,30);
       withdrawl.addActionListener(this);
       image.add(withdrawl);

       cash= new JButton("Cash");
       cash.setBounds(170,450,100,30);
       cash.addActionListener(this);
       image.add(cash);

       statement= new JButton("Mini Statement");
       statement.setBounds(360,450,150,30);
       statement.addActionListener(this);
       image.add(statement);

       pin_change= new JButton("Pin Change");
       pin_change.setBounds(170,485,100,30);
       pin_change.addActionListener(this);
       image.add(pin_change);

       balance= new JButton("Balance Enquiry");
       balance.setBounds(360,485,150,30);
       balance.addActionListener(this);
       image.add(balance);

       exit= new JButton("Exit");
       exit.setBounds(360,520,150,30);
       exit.addActionListener(this);
       image.add(exit);


       
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        } else if(e.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber,cardnumber).setVisible(true);
        }else if(e.getSource()== withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber,cardnumber).setVisible(true);
        } else if(e.getSource()==cash){
            setVisible(false);
            new Cash(pinnumber,cardnumber).setVisible(true);
        }else if(e.getSource()==pin_change){
            setVisible(false);
            new pinChange(pinnumber,cardnumber).setVisible(true);
        }else if(e.getSource()==balance){
            setVisible(false);
            new Enquiry(pinnumber,cardnumber).setVisible(true);
        }else if(e.getSource()==statement){
            setVisible(false);
            new Statement(pinnumber,cardnumber).setVisible(true);
        }
       

    }
    
}

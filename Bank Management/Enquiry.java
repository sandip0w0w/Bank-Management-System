import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Enquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;
    String cardnumber;
    JLabel text;

    Enquiry(String pinnumber,String cardnumber){
        this.pinnumber=pinnumber;
        this.cardnumber=cardnumber;
        setLayout(null);
        ImageIcon icon1=new ImageIcon("atm.jpg");
       Image icon2=icon1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon icon3= new ImageIcon(icon2);
       JLabel image= new JLabel(icon3);
       image.setBounds(0,0,900,900);
       add(image);


       back=new JButton("Back");
       back.setBounds(355,520,150,30);
       back.setBackground(Color.WHITE);
       back.setForeground(Color.BLACK);
       back.addActionListener(this);
       image.add(back);

       Conn c=new Conn();
       int balance=0;
       try{
           ResultSet rs=c.s.executeQuery("select * from bank where accountNumber='"+cardnumber+"'");
           
           while(rs.next()){
               if(rs.getString("type").equals("Deposit")){
                   balance+=Integer.parseInt(rs.getString("amount"));
               }else{
                   balance-=Integer.parseInt(rs.getString("amount"));
               }
            }
        }catch (Exception ae){
            System.out.println(ae);
        }
       
        text= new JLabel("Your current Account balance is Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);


        
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
          setVisible(false);
        new Transactions(pinnumber,cardnumber).setVisible(true);
        
    
}
}

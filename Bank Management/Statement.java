import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.*;

public class Statement  extends JFrame{
    JLabel mini,bank,card,balance_amt;
      String pinnumber;
      String cardnumber;
    Statement(String pinnumber,String cardnumber){
        this.pinnumber=pinnumber;
        this.cardnumber=cardnumber;
        setLayout(null);
        
           mini= new JLabel();
           mini.setBounds(15,180,400,200);
           add(mini);

           bank= new JLabel("National Bank");
           bank.setBounds(150,20,100,20);
           add(bank);

            card= new JLabel();
           card.setBounds(20,80,300,20);
           add(card);

           balance_amt= new JLabel();
          balance_amt.setBounds(150,520,400,20);
           add(balance_amt);


           

           try{ 
            Conn c=new Conn();
           ResultSet rs= c.s.executeQuery("select * from login where cardNumber='"+cardnumber+"'");
             while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12) );
             }  
           }catch (Exception e){
            System.out.println(e);
           }

           try{
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from bank where accountNumber='"+cardnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>"+"\n"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br>");
            }

           } catch(Exception e){
            System.out.println(e);
           }

           try{
            Conn c=new Conn();
            
            ResultSet rs=c.s.executeQuery("select * from bank where accountNumber='"+cardnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                balance_amt.setText("Your current account balance is Rs "+ balance);


           }catch(Exception e){
            System.out.println(e);
           }   






        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

   
}

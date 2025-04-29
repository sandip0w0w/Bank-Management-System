import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class pinChange extends JFrame implements ActionListener{

    String pinnumber,cardnumber;
    JLabel text,pintext,repintext;
    JTextField pinField,repinField;

    JButton change,back;


    pinChange(String pinnumber,String cardnumber){
       this.pinnumber=pinnumber;
       this.cardnumber=cardnumber;
         setLayout(null);

       ImageIcon icon1=new ImageIcon("atm.jpg");
       Image icon2=icon1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon icon3= new ImageIcon(icon2);
       JLabel image= new JLabel(icon3);
       image.setBounds(0,0,900,900);
       add(image);


       text= new JLabel("Change your pin");
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Syste",Font.BOLD,16));
       text.setBounds(250,280,500,35);
       image.add(text);

       pintext= new JLabel("Enter new pin:");
       pintext.setForeground(Color.WHITE);
       pintext.setFont(new Font("Syste",Font.BOLD,16));
       pintext.setBounds(165,350,500,35);
       image.add(pintext);

       repintext= new JLabel("Re-Enter new pin:");
       repintext.setForeground(Color.WHITE);
       repintext.setFont(new Font("System",Font.BOLD,16));
       repintext.setBounds(165,390,500,35);
       image.add(repintext);


       pinField= new JTextField();
       pinField.setBounds(340,350,160,35);
       pinField.setFont(new Font("System",Font.BOLD,16));
       image.add(pinField);


       repinField= new JTextField();
       repinField.setBounds(340,390,160,35);
       repinField.setFont(new Font("System",Font.BOLD,16));
       image.add(repinField);



       change=new JButton("Change");
       change.setBounds(240,460,100,25);
       change.setBackground(Color.BLACK);
       change.setForeground(Color.WHITE);
       change.addActionListener(this);
       image.add(change);


       back=new JButton("Back");
       back.setBounds(380,460,100,25);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       image.add(back);



       setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber,cardnumber).setVisible(true);
        }else if(e.getSource()==change){
            try{
                String npin=pinField.getText();
                String renpin=repinField.getText();
                if(!npin.equals(renpin)){
                    JOptionPane.showMessageDialog(null,"Entered pin doesn't match");
                    return;
                }
                if(npin.equals("")){

                  JOptionPane.showMessageDialog(null,"Please enter new pin");
                    return;
                }
                if(renpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new pin");
                    return;
                }
                Conn c=new Conn();
                
                String query2="update login set pinNumber='"+renpin+"' where pinNumber='"+pinnumber+"'";
                String query3="update signup3 set pinNumber='"+renpin+"' where pinNumber='"+pinnumber+"'";
                
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin change Successfully");
                setVisible(false);
                new Transactions(pinnumber,cardnumber).setVisible(true);
            }
            catch (Exception ae){
                System.out.println(ae);
                
    
            }
        }

    }
    
}

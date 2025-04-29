import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    JLabel deposit;
    JTextField depositTextField;
    JButton deposit_amt,back;
    String pinnumber;
    String cardnumber;


    Deposit(String pinnumber,String cardnumber ){
       this.pinnumber=pinnumber;
       this.cardnumber=cardnumber;
        ImageIcon icon1= new ImageIcon("atm.jpg");
        Image icon2=icon1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon icon3=new ImageIcon(icon2);
        JLabel image=new JLabel(icon3);
        image.setBounds(0,0,900,900);
        add(image);


        deposit= new JLabel("Enter the amount you want to deposit:");
        deposit.setBounds(170,300,400,20);
        deposit.setFont(new Font("Ostwalds",Font.BOLD,16));
        deposit.setForeground(Color.WHITE);
        image.add(deposit);

        depositTextField=new JTextField();
        depositTextField.setFont(new Font("Raleway",Font.BOLD,18));
        depositTextField.setBounds(170,350,320,25);
        image.add(depositTextField);


        deposit_amt=new JButton("Deposit");
        deposit_amt.setBounds(355,450,150,30);
        deposit_amt.addActionListener(this);
        image.add(deposit_amt);

        back=new JButton("Back");
        back.setBounds(355,490,150,30);
        back.addActionListener(this);
        image.add(back);







        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==deposit_amt){

            String number=depositTextField.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"No amount entered");
            }else{
                try{

                Conn c= new Conn();
                String query="insert into bank values('"+cardnumber+"','"+date+"','Deposit','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
                
            
            }catch(Exception ae){
                    System.out.println(ae);

                }
            }



        }else if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber,cardnumber).setVisible(true);



        }

    }
    
}

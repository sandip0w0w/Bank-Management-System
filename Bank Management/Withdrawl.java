import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener{
    JLabel withdrawl;
    JTextField withdrawlTextField;
    JButton withdrawl_amt,back;
    String pinnumber;
    String cardnumber;


    Withdrawl(String pinnumber,String cardnumber ){
       this.pinnumber=pinnumber;
       this.cardnumber=cardnumber;
        ImageIcon icon1= new ImageIcon("atm.jpg");
        Image icon2=icon1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon icon3=new ImageIcon(icon2);
        JLabel image=new JLabel(icon3);
        image.setBounds(0,0,900,900);
        add(image);


        withdrawl= new JLabel("Enter the amount you want to Withdraw:");
        withdrawl.setBounds(170,300,400,20);
        withdrawl.setFont(new Font("Ostwalds",Font.BOLD,16));
        withdrawl.setForeground(Color.WHITE);
        image.add(withdrawl);

        withdrawlTextField=new JTextField();
        withdrawlTextField.setFont(new Font("Raleway",Font.BOLD,18));
        withdrawlTextField.setBounds(170,350,320,25);
        image.add(withdrawlTextField);


        withdrawl_amt=new JButton("Withdraw");
        withdrawl_amt.setBounds(355,450,150,30);
        withdrawl_amt.addActionListener(this);
        image.add(withdrawl_amt);

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

        if(e.getSource()==withdrawl_amt){

            String number=withdrawlTextField.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"No amount entered");
            }else{
                try{

                Conn c= new Conn();
                String query="insert into bank values('"+cardnumber+"','"+date+"','Withdrawl','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawed Successfully");
                
            
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

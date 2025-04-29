import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel label= new JLabel();
    ImageIcon image=new ImageIcon("logo.jpg");
    JButton login,clear,signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        Image i2= image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
       
        this.setLayout(null);
        label.setIcon(i3);
        label.setText("Welcome to ATM Machine");
        label.setBounds(70,10,100,100);
        getContentPane().setBackground(Color.WHITE);
       JLabel text=new JLabel("Welcome to ATM");
       text.setFont(new Font("Ostward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        this.add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Ostward",Font.BOLD,36));
        cardno.setBounds(90,150,400,30);
        this.add(cardno);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Ostward",Font.BOLD,36));
        pin.setBounds(90,240,400,30);
        this.add(pin);

        cardTextField= new JTextField();
        cardTextField.setBounds(300,150,230,30);
        this.add(cardTextField);

         pinTextField= new JPasswordField();
        pinTextField.setBounds(300,240,230,30);
        this.add(pinTextField);

         login= new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        
        this.add(login);

        clear= new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

         signUp= new JButton("Sign Up");
        signUp.setBounds(300,350,230,30);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
    

        
        
        
    
        
        
        
        this.setTitle("AUTOMATED TELLER MACHINE");
        this.setSize(800,500);
        this.setLocation(450,200);
        this.add(label);
        this.setVisible(true);
        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            
            Conn c=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where cardNumber= '"+cardnumber+"' and pinNumber= '"+pinnumber+"'";
            try{
            ResultSet resultSet = c.s.executeQuery(query);
            if(resultSet.next()){
                setVisible(false);
                new Transactions(pinnumber,cardnumber).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
            }
        }catch(Exception ae){
            System.out.println(ae);
        }
            

        }
        else if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");

        }
        else if(e.getSource()==signUp){
           new signUp1();
           setVisible(false); 

        }

        
      
        
    }

}

      

       




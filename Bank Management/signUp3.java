import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class signUp3 extends JFrame implements ActionListener{
    JLabel head,card_num_dummy,form_no,pin_num_dummy,acc_type,card_num,card_description,card_description2,pin_num,pin_description,card_service,policy;
    JRadioButton saving_acc,fixed_acc,current_acc,recurring_acc;
    JCheckBox atm,internet,mobile,email,cheque,e_statement,policy_box;
    JButton submit,cancel;
    String formno;

    signUp3(String formno){
        this.formno=formno;
        
        ImageIcon image= new ImageIcon("logo.jpg");
        

        JLabel image1=new JLabel();
         
         Image image2=image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
         ImageIcon image3= new ImageIcon(image2);
         image1.setIcon(image3);
         image1.setBounds(80,5,100,100);
         add(image1);
         setLayout(null);
         

         head= new JLabel("Page 3:Account Details");
         head.setBounds(230,40,500,40);
         head.setFont(new Font("Ostwalds",Font.BOLD,24));
         add(head);

         form_no=new JLabel("Form no: "+formno);
         form_no.setBounds(630,30,600,40);
         form_no.setFont(new Font("Ostward",Font.BOLD,18));
         add(form_no);

         acc_type= new JLabel("Account Type:");
         acc_type.setBounds(70,170,500,40);
         acc_type.setFont(new Font("Ostwalds",Font.BOLD,20));
         add(acc_type);

         saving_acc=new JRadioButton("Saving Account");
         saving_acc.setBounds(70,210,200,40);
         saving_acc.setBackground(Color.WHITE);
         add(saving_acc);


         fixed_acc=new JRadioButton("Fixed Deposit Account");
         fixed_acc.setBounds(300,210,500,40);
         fixed_acc.setBackground(Color.WHITE);
         add(fixed_acc);


         current_acc=new JRadioButton("Current Account");
         current_acc.setBounds(70,240,200,40);
         current_acc.setBackground(Color.WHITE);
         add(current_acc);


         recurring_acc=new JRadioButton("Recurring Deposit Account");
         recurring_acc.setBounds(300,240,500,40);
         recurring_acc.setBackground(Color.WHITE);
         add(recurring_acc);

         ButtonGroup acc_group=new ButtonGroup();
         acc_group.add(saving_acc);
         acc_group.add(fixed_acc);
         acc_group.add(current_acc);
         acc_group.add(recurring_acc);

         card_num=new JLabel("Card Number:");
         card_num.setBounds(70,300,500,40);
         card_num.setFont(new Font("Ostwalds",Font.BOLD,20));
         add(card_num);



         card_num_dummy=new JLabel("XXXX-XXXX-XXXX-3456");
         card_num_dummy.setBounds(300,300,300,40);
         card_num_dummy.setFont(new Font("Ostwalds",Font.BOLD,20));
         add(card_num_dummy);

         card_description=new JLabel("(Your 16-digit Card Number)");
         card_description.setBounds(70,320,500,40);
         card_description.setFont(new Font("Ostwalds",Font.BOLD,10));
         add(card_description);


         card_description2=new JLabel("It would appear on ATM card cheque book and statements");
         card_description2.setBounds(300,320,500,40);
         card_description2.setFont(new Font("Ostwalds",Font.BOLD,10));
         add(card_description2);


         pin_num=new JLabel("PIN:");
         pin_num.setBounds(70,370,500,40);
         pin_num.setFont(new Font("Ostwalds",Font.BOLD,20));
         add(pin_num);


         pin_num_dummy=new JLabel("XXXX");
         pin_num_dummy.setBounds(300,370,300,40);
         pin_num_dummy.setFont(new Font("Ostwalds",Font.BOLD,20));
         add(pin_num_dummy);


         pin_description=new JLabel("(4-digit password)");
         pin_description.setBounds(70,390,500,40);
         pin_description.setFont(new Font("Ostwalds",Font.BOLD,10));
         add(pin_description);
         


         card_service=new JLabel("Services:");
         card_service.setBounds(70,440,500,40);
         card_service.setFont(new Font("Ostwalds",Font.BOLD,20));
         add(card_service);

         atm=new JCheckBox("ATM CARD");
         atm.setBounds(70,490,200,40);
         atm.setBackground(Color.WHITE);
         add(atm);


         internet=new JCheckBox("Internet Banking");
         internet.setBounds(300,490,200,40);
         internet.setBackground(Color.WHITE);
         add(internet);


         mobile=new JCheckBox("Mobile Banking");
         mobile.setBounds(70,540,200,40);
         mobile.setBackground(Color.WHITE);
         add(mobile);


         email=new JCheckBox("EMAIL Alerts");
         email.setBounds(300,540,200,40);
         email.setBackground(Color.WHITE);
         add(email);

         cheque=new JCheckBox("Cheque Book");
         cheque.setBounds(70,590,200,40);
         cheque.setBackground(Color.WHITE);
         add(cheque);


         e_statement=new JCheckBox("E-Statement");
         e_statement.setBounds(300,590,200,40);
         e_statement.setBackground(Color.WHITE);
         add(e_statement);

         policy_box=new JCheckBox();
         policy_box.setBounds(70,640,20,40);
         policy_box.setBackground(Color.WHITE);
         add(policy_box);


         policy= new JLabel("I hereby declare that the above entered details correct to the base of my knowledge");
         policy.setBounds(95,640,1000,40);
         policy.setFont(new Font("Ostwalds",Font.BOLD,12));
         add(policy);

         submit =new JButton("Submit");
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.setBounds(250,680,100,20);
         submit.addActionListener(this);
         add(submit);

         cancel=new JButton("Cancel");
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         cancel.setBounds(390,680,100,20);
         cancel.addActionListener(this);
         add(cancel);








         getContentPane().setBackground(Color.WHITE);
         setSize(800,800);
         setLocation(400,80);
         setVisible(true);


         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){

            String accountType=null;
            if(saving_acc.isSelected()){
                accountType="Saving Account";
            }else if(current_acc.isSelected()){
                accountType="Current Account";
            }
            else if(fixed_acc.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(recurring_acc.isSelected()){
                accountType="Recurring Deposit Account";
            }
            Random random=new Random();
            String cardnumber= ""+ Math.abs((random.nextLong() % 90000000)+ 5098078900000000L);
            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility="";
            if(atm.isSelected()){
                facility=facility+" ATM Card";
            }
            else if(mobile.isSelected()){
                facility=facility+" Mobile Banking";
            }
            else if(email.isSelected()){
                facility=facility+" Email Alerts";
            }
            else if(cheque.isSelected()){
                facility=facility+" Cheque Book";
            }
            else if(e_statement.isSelected()){
                facility=facility+" E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Incomplete");
                }else{
              Conn c=new Conn();
              String query1="insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"', '"+pinnumber+"','"+facility+"')";
              String query2="insert into login values('"+formno+"','"+cardnumber+"', '"+pinnumber+"')";
              c.s.executeUpdate(query1); 
              c.s.executeUpdate(query2); 

              JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n Pin: "+ pinnumber);
          

            } }catch(Exception ae){
                System.out.println(ae);


            }


            
    }else if(e.getSource()==cancel){

        }

       
    }
    
}

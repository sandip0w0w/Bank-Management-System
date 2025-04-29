
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.*;;


public class signUp1 extends JFrame implements ActionListener{
  
  JTextField name_field,fathername_field,email_field,address_field,city_field,state_field,pin_field,dob;

  JButton next;

  JRadioButton male,female,married,unmarried;

  JDateChooser dateChooser;
  Random ran= new Random();
        long random=Math.abs((ran.nextLong() %9000L)+1000L);
        
        
    
    
   
    signUp1(){
        this.setTitle("ACCOUNT REGISTRATION FORM");
        
        
        
        
       this.setLayout(null);
        this.setSize(800,800);
        this.setVisible(true);
        this.setLocation(450,100);
        ImageIcon image= new ImageIcon("logo.jpg");
        

       JLabel image1=new JLabel();
        
        Image image2=image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon image3= new ImageIcon(image2);
        image1.setIcon(image3);
        image1.setBounds(70,10,100,100);
        
      
      JLabel text= new JLabel("APPLICATION FORM NO."+""+random);
       text.setBounds(200,10,500,100);
       text.setFont(new Font("Ostward",Font.BOLD,35));

       JLabel head= new JLabel("Page 1:Personal Details");
       add(head);
       head.setBounds(270,60,500,100);
       head.setFont(new Font("Ostwald",Font.BOLD,20));

       JLabel name= new JLabel("Name:");
       add(name);
       name.setBounds(100,140,500,30);
       name.setFont(new Font("Ostwald",Font.BOLD,20));

        name_field=new JTextField();
       name_field.setBounds(270,140,500,30);
       add(name_field);

       JLabel fathers_name= new JLabel("Father's Name:");
       fathers_name.setBounds(100,190,500,30);
       fathers_name.setFont(new Font("Ostwald",Font.BOLD,20));
       add(fathers_name);


       fathername_field=new JTextField();
       fathername_field.setBounds(270,190,500,30);
       add(fathername_field);

       JLabel dob= new JLabel("Date of Birth:");
       dob.setBounds(100,240,500,30);
       dob.setFont(new Font("Ostwald",Font.BOLD,20));
       add(dob);

       dateChooser= new JDateChooser();
       dateChooser.setBounds(270,240,500,30);
       add(dateChooser);


       JLabel gender= new JLabel("Gender:");
       gender.setBounds(100,290,500,30);
       gender.setFont(new Font("Ostwald",Font.BOLD,20));
       add(gender);


        male=new JRadioButton("Male");
       
       male.setBounds(270,290,100,30);
        female=new JRadioButton("Female");
       female.setBounds(450,290,100,30);
       add(male);
       add(female);
       ButtonGroup gendergroup= new ButtonGroup();
       gendergroup.add(male);
       gendergroup.add(female);


       JLabel email= new JLabel("Email Address");
       email.setBounds(100,340,500,30);
       email.setFont(new Font("Ostwald",Font.BOLD,20));
       add(email);

        email_field=new JTextField();
       email_field.setBounds(270,340,500,30);
       add(email_field);



       JLabel marital= new JLabel("Marital Status:");
       marital.setBounds(100,390,500,30);
       marital.setFont(new Font("Ostwald",Font.BOLD,20));
       add(marital);

        married=new JRadioButton("Married");
       
       married.setBounds(270,390,100,30);
       unmarried=new JRadioButton("Unmarried");
       unmarried.setBounds(450,390,100,30);
       add(married);
       add(unmarried);
       ButtonGroup marriedgroup= new ButtonGroup();
       marriedgroup.add(married);
       marriedgroup.add(unmarried);
       


       JLabel address= new JLabel("Address:");
       address.setBounds(100,440,500,30);
       address.setFont(new Font("Ostwald",Font.BOLD,20));
       add(address);


        address_field=new JTextField();
       address_field.setBounds(270,440,500,30);
       add(address_field);


       JLabel city= new JLabel("City:");
       city.setBounds(100,490,500,30);
       city.setFont(new Font("Ostwald",Font.BOLD,20));
       add(city);


        city_field=new JTextField();
       city_field.setBounds(270,490,500,30);
       add(city_field);


       JLabel pin= new JLabel("Pin Code:");
       pin.setBounds(100,540,500,30);
       pin.setFont(new Font("Ostwald",Font.BOLD,20));
       add(pin);


        pin_field=new JTextField();
       pin_field.setBounds(270,540,500,30);
       add(pin_field);


       JLabel state= new JLabel("State:");
       state.setBounds(100,590,500,30);
       state.setFont(new Font("Ostwald",Font.BOLD,20));
       add(state);


       state_field=new JTextField();
       state_field.setBounds(270,590,500,30);
       add(state_field);

       next=new JButton("Next");
       next.setBackground(Color.BLACK);
       next.setForeground(Color.white);
       next.setFont(new Font("Ostwalds",Font.BOLD,20));
       next.setBounds(650,640,100,30);
       next.addActionListener(this);
       this.add(next);

       


       
       getContentPane().setBackground(Color.WHITE);
        this.add(text); 
       this.add(image1);
        
       

    }



    @Override
    public void actionPerformed(ActionEvent ae) {
     String formno=""+ random;
      String name=name_field.getText();
      String fathers_name=fathername_field.getText();
      String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

      String gender=null;
      if(male.isSelected()){
        gender="Male";

      }else if(female.isSelected()){
        gender="Female";
      }
      String email=email_field.getText();
      String marital=null;
      if(married.isSelected()){
        marital="Married";
      }
      else if(unmarried.isSelected()){
        marital="Unmarried";
      }
      String address=address_field.getText();
      String city=city_field.getText();
      String state=state_field.getText();
      String pin=pin_field.getText();
      
      try{
        if(name.equals("")){
          JOptionPane.showMessageDialog(null, "Name is required");
        } else{
          Conn c= new Conn();
          String query="insert into signup values('"+formno+"','"+name+"','"+fathers_name+"', '"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
          c.s.executeUpdate(query);
          setVisible(false);
          new signUp2(formno).setVisible(true);
        }
      }
      catch(Exception e){
        System.out.println(ae);
      }
      }

    }

    
   

    
  
    


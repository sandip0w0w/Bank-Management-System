import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class signUp2  extends JFrame implements ActionListener{
    JLabel head,religion,category,income,education,occupation,
    pan_num,current_acc,senior,qualification,form_no;

    JTextField panNum_field;
    JRadioButton senior_yes,senior_no,account_yes,account_no;
    JButton next;
    
    
    @SuppressWarnings("rawtypes")
    JComboBox  religionBox,categoryBox,incomeBox,educationBox,
    occupationBox;
    String formno;

    
    
      
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    signUp2(String formno){
        this.formno=formno;
        ImageIcon image= new ImageIcon("logo.jpg");
        

        JLabel image1=new JLabel();
         
         Image image2=image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
         ImageIcon image3= new ImageIcon(image2);
         image1.setIcon(image3);
         image1.setBounds(80,5,100,100);
         add(image1);
         setLayout(null);



         form_no=new JLabel("Form no: "+formno);
         form_no.setBounds(660,30,600,40);
         form_no.setFont(new Font("Ostward",Font.BOLD,23));
         add(form_no);

         head=new JLabel("Page 2:Additional Details");
         head.setBounds(220,30,600,40);
         head.setFont(new Font("Ostward",Font.BOLD,27));
         add(head);

         religion= new JLabel("Religion:");
         religion.setBounds(80,130,400,30);
         religion.setFont(new Font("Ostward",Font.BOLD,20));
         add(religion);
          
         String religion_opt[] = {"Hindu","Muslim","Sikh","Christian"};

         religionBox=new JComboBox(religion_opt);
         religionBox.setBounds(270,130,400,30);
         add(religionBox);

         category= new JLabel("Category:");
         category.setBounds(80,180,400,30);
         category.setFont(new Font("Ostward",Font.BOLD,20));
         add(category);

         String category_opt[]= {"Savings","Current","Real","GenZ"};
         categoryBox=new JComboBox(category_opt);
         categoryBox.setBounds(270,180,400,30);
         add(categoryBox);



         income= new JLabel("Income:");
         income.setBounds(80,230,400,40);
         income.setFont(new Font("Ostward",Font.BOLD,20));
         add(income);

         String income_opt[]= {"Business","Salary","Remittance","Students"};
         incomeBox=new JComboBox(income_opt);
         incomeBox.setBounds(270,230,400,30);
         add(incomeBox);


         education= new JLabel("Educational:");
         education.setBounds(80,280,400,40);
         education.setFont(new Font("Ostward",Font.BOLD,20));
         add(education);

         String education_opt[]= {"SLC","Bachelors","Masters","Below SLC"};
         educationBox=new JComboBox(education_opt);
         educationBox.setBounds(270,280,400,30);
         add(educationBox);


         qualification= new JLabel("Qualification");
         qualification.setBounds(80,300,400,40);
         qualification.setFont(new Font("Ostward",Font.BOLD,20));
         add(qualification);


         occupation= new JLabel("Occupation:");
         occupation.setBounds(80,350,400,40);
         occupation.setFont(new Font("Ostward",Font.BOLD,20));
         add(occupation);


         String occupation_opt[]= {"Business","Private","Government","Student"};
         occupationBox=new JComboBox(occupation_opt);
         occupationBox.setBounds(270,350,400,30);
         add(occupationBox);

         pan_num= new JLabel("PAN Number:");
         pan_num.setBounds(80,400,400,30);
         pan_num.setFont(new Font("Ostward",Font.BOLD,20));
         add(pan_num);

         panNum_field= new JTextField();
         panNum_field.setBounds(270,400,400,30);
         add(panNum_field);

         senior= new JLabel("Senior Citizen:");
         senior.setBounds(80,450,400,40);
         senior.setFont(new Font("Ostward",Font.BOLD,20));
         add(senior);

         senior_yes= new JRadioButton("Yes");
         senior_no= new JRadioButton("No");
         senior_yes.setBounds(270,450,100,40);
         senior_no.setBounds(400,450,100,40);
         senior_yes.setBackground(Color.WHITE);
         senior_no.setBackground(Color.WHITE);
         add(senior_yes);
         add(senior_no);


         ButtonGroup agegroup=new  ButtonGroup();
         agegroup.add(senior_yes);
         agegroup.add(senior_no);

         

         current_acc= new JLabel("Existing Account:");
         current_acc.setBounds(80,500,400,40);
         current_acc.setFont(new Font("Ostward",Font.BOLD,20));
         add(current_acc);


         account_yes= new JRadioButton("Yes");
         account_no= new JRadioButton("No");
         account_yes.setBounds(270,500,100,40);
         account_yes.setBackground(Color.WHITE);
         account_no.setBackground(Color.WHITE);
         account_no.setBounds(400,500,100,40);
         add(account_yes);
         add(account_no);


         ButtonGroup accountgroup=new  ButtonGroup();
         accountgroup.add(account_yes);
         accountgroup.add(account_no);

         next= new JButton("Next");
         next.setBounds(650,650,100,40);
         next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.addActionListener(this);
         add(next);

        


        setTitle("NEW ACCOUNT OPENING");
        setLocation(400,50);
        setSize(900,800);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String sreligion= (String) religionBox.getSelectedItem();
        String scategory=(String) categoryBox.getSelectedItem();
        String sincome=(String) incomeBox.getSelectedItem();
        String seducation=(String) educationBox.getSelectedItem();
        String soccupation=(String) occupationBox.getSelectedItem();
        String senior=null;
        if(senior_yes.isSelected()){
            senior="Yes";

        }
        else if(senior_no.isSelected()){
            senior="No";
        }
        String existing_account=null;
        
        if(account_yes.isSelected()){
            existing_account="Yes";

        }
        else if(account_no.isSelected()){
            existing_account="No";
        }

        String pan=panNum_field.getText();
        try{
            Conn c=new Conn();
            String query="insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"', '"+soccupation+"','"+sincome+"','"+existing_account+"','"+senior+"','"+pan+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new signUp3(formno).setVisible(true);
           


        } catch(Exception ae){
            System.out.println(ae);
        }
        
        
    }

    
}

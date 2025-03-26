import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUpOne extends JFrame implements ActionListener {

    public static long Rnd;
    JTextField NameField,FatherNameField,EmailLabel,AddressLabel,CityLabel,PinLabel;
    JDateChooser chooser;
    JRadioButton Male ,Femail,Married,UnMarried;
    JButton Next;
    SignUpOne(){
        setTitle("APPLICATION FORM");

        setLayout(null);

        Random ran =new Random();
        Rnd=(Math.abs((ran.nextLong()%900L)+100L));
        JLabel Form = new JLabel("APPLICATION FORM NO. "+Rnd);
        Form.setFont(new Font("Raleway",Font.BOLD,38));
        Form.setBounds(140,20,600,40);
        add(Form);

        JLabel Personal = new JLabel("Page 1: Personal Details");
        Personal.setFont(new Font("Raleway",Font.BOLD,28));
        Personal.setBounds(280,80,400,30);
        add(Personal);

        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("Raleway",Font.BOLD,20));
        Name.setBounds(180,140,100,30);
        add(Name);

        NameField = new JTextField();
        NameField.setFont(new Font("Raleway",Font.BOLD,14));
        NameField.setBounds(400,140,400,30);
        add(NameField);

        JLabel FName = new JLabel("Fathers Name:");
        FName.setFont(new Font("Raleway",Font.BOLD,20));
        FName.setBounds(180,190,150,30);
        add(FName);

        FatherNameField = new JTextField();
        FatherNameField.setFont(new Font("Raleway",Font.BOLD,14));
        FatherNameField.setBounds(400,190,400,30);
        add(FatherNameField);


        JLabel DOB = new JLabel("Date OF Birth:");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(180,240,200,30);
        add(DOB);

        chooser=new JDateChooser();
        chooser.setBounds(400,240,398,30);
        chooser.setForeground(new Color(105,105,105));
        add(chooser);

        JLabel Gender = new JLabel("Gender:");
        Gender.setFont(new Font("Raleway",Font.BOLD,20));
        Gender.setBounds(180,290,200,30);
        add(Gender);

        Male=new JRadioButton("Male");
        Male.setBounds(400,290,100,30);
        add(Male);

        Femail=new JRadioButton("Female");
        Femail.setBounds(550,290,100,30);
        add(Femail);

        ButtonGroup group =new ButtonGroup();
        group.add(Male);
        group.add(Femail);

        JLabel Email = new JLabel("Email Address:");
        Email.setFont(new Font("Raleway",Font.BOLD,20));
        Email.setBounds(180,340,200,30);
        add(Email);

        EmailLabel = new JTextField();
        EmailLabel.setFont(new Font("Raleway",Font.BOLD,14));
        EmailLabel.setBounds(400,340,400,30);
        add(EmailLabel);

        JLabel Marital = new JLabel("Marital Status:");
        Marital.setFont(new Font("Raleway",Font.BOLD,20));
        Marital.setBounds(180,390,200,30);
        add(Marital);

        Married=new JRadioButton("Marries");
        Married.setBounds(400,390,100,30);
        add(Married);

        UnMarried=new JRadioButton("UnMarried");
        UnMarried.setBounds(550,390,100,30);
        add(UnMarried);

        ButtonGroup group1 =new ButtonGroup();
        group1.add(Married);
        group1.add(UnMarried);

        JLabel Address = new JLabel("Address:");
        Address.setFont(new Font("Raleway",Font.BOLD,20));
        Address.setBounds(180,440,200,30);
        add(Address);

        AddressLabel = new JTextField();
        AddressLabel.setFont(new Font("Raleway",Font.BOLD,14));
        AddressLabel.setBounds(400,440,400,30);
        add(AddressLabel);

        JLabel City = new JLabel("City:");
        City.setFont(new Font("Raleway",Font.BOLD,20));
        City.setBounds(180,490,200,30);
        add(City);

        CityLabel = new JTextField();
        CityLabel.setFont(new Font("Raleway",Font.BOLD,14));
        CityLabel.setBounds(400,490,400,30);
        add(CityLabel);


        JLabel Pincode = new JLabel("Pin Code:");
        Pincode.setFont(new Font("Raleway",Font.BOLD,20));
        Pincode.setBounds(180,540,200,30);
        add(Pincode);

        PinLabel = new JTextField();
        PinLabel.setFont(new Font("Raleway",Font.BOLD,14));
        PinLabel.setBounds(400,540,400,30);
        add(PinLabel);

        Next=new JButton("Next");
        Next.setBounds(620,660,100,35);
        Next.setForeground(Color.BLUE);
        Next.setFont(new Font("Arial", Font.BOLD, 15));
        Next.addActionListener(this);
        add(Next);

        setSize(850,800);
        setVisible(true);

        getContentPane().setBackground(Color.white);

        setLocation(390,160);

    }
    public static void main(String[] args) {
        new SignUpOne();
    }

    public void actionPerformed(ActionEvent ae){
        String FormNo=""+ Rnd;
        String name=NameField.getText();
        String FName=FatherNameField.getText();
        String DOB=((JTextField)chooser.getDateEditor().getUiComponent()).getText();
        String Gender="Null";
        if(Male.isSelected()){
            Gender="Male";
        }else {
            Gender="Femail";
        }
        String Mail=EmailLabel.getText();
        String Marital="Null";
        if(Married.isSelected()){
            Marital="Married";
        }else{
            Marital="UnMarried";
        }
        String Address=AddressLabel.getText();
        String City=CityLabel.getText();
        String PIN=PinLabel.getText();

        try {
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(null,"Name Required");
            } else if (FName.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Father Name Required");
            }else if (DOB.isEmpty()) {
                JOptionPane.showMessageDialog(null,"DOB Required");
            }else if (Mail.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Email Address Required");
            }else if (Address.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Address Required");
            } else if (City.isEmpty()) {
                JOptionPane.showMessageDialog(null,"City Required");
            } else if (PIN.isEmpty()) {
                JOptionPane.showMessageDialog(null,"PIN Required");
            }else {
                Con c=new Con();
                String query= "insert into signup values('"+FormNo+"','"+name+"','"+FName+"','"+DOB+"','"+Gender+"','"+Mail+"','"+Marital+"','"+Address+"','"+City+"','"+PIN+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                SignUpTwo cal=new SignUpTwo();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

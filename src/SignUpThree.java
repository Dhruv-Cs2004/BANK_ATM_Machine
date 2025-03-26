import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox s1,s2,s3,s4,s5,s6,s7;
    JButton Submit,Cancel;
    String pinNumber,cardNumber;
    SignUpThree(){
        setTitle("Account Details");

        setLayout(null);

        JLabel Third = new JLabel("Page 3: Account Details");
        Third.setFont(new Font("Raleway",Font.BOLD,28));
        Third.setBounds(280,80,400,30);
        add(Third);

        JLabel AccountLable = new JLabel("Account Type");
        AccountLable.setFont(new Font("Raleway",Font.BOLD,22));
        AccountLable.setBounds(100,140,200,30);
        add(AccountLable);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(105,180,200,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(365,180,250,20);
        add(r2);

        r3=new JRadioButton("Current");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(105,220,200,20);
        add(r3);

        r4=new JRadioButton("Requiring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(365,220,260,20);
        add(r4);

        ButtonGroup Group=new ButtonGroup();
        Group.add(r1);
        Group.add(r2);
        Group.add(r3);
        Group.add(r4);

        JLabel CardLabel = new JLabel("Card Number");
        CardLabel.setFont(new Font("Raleway",Font.BOLD,22));
        CardLabel.setBounds(100,300,200,30);
        add(CardLabel);

        JLabel Number = new JLabel("XXXX-XXXX-XXXX-4184");
        Number.setFont(new Font("Raleway",Font.BOLD,22));
        Number.setBounds(330,300,300,30);
        add(Number);

        JLabel info = new JLabel("Your 16 Digit Card Number");
        info.setFont(new Font("Raleway",Font.BOLD,12));
        info.setBounds(100,330,200,20);
        add(info);

        JLabel PIN = new JLabel("PIN");
        PIN.setFont(new Font("Raleway",Font.BOLD,22));
        PIN.setBounds(100,370,200,30);
        add(PIN);

        JLabel PinNum = new JLabel("XXXX");
        PinNum.setFont(new Font("Raleway",Font.BOLD,22));
        PinNum.setBounds(330,370,200,30);
        add(PinNum);

        JLabel infoPin = new JLabel("Your 4 Digit PIN Number");
        infoPin.setFont(new Font("Raleway",Font.BOLD,12));
        infoPin.setBounds(100,400,200,20);
        add(infoPin);

        JLabel Services = new JLabel("Services Required");
        Services.setFont(new Font("Raleway",Font.BOLD,22));
        Services.setBounds(330,450,250,30);
        add(Services);

        s1 =new JCheckBox("ATM CARD");
        s1.setBackground(Color.WHITE);
        s1.setFont(new Font("Raleway",Font.BOLD,16));
        s1.setBounds(100,500,200,30);
        add(s1);

        s2 =new JCheckBox("Internet Banking");
        s2.setBackground(Color.WHITE);
        s2.setFont(new Font("Raleway",Font.BOLD,16));
        s2.setBounds(350,500,200,30);
        add(s2);

        s3 =new JCheckBox("Mobile Banking");
        s3.setBackground(Color.WHITE);
        s3.setFont(new Font("Raleway",Font.BOLD,16));
        s3.setBounds(100,550,200,30);
        add(s3);

        s4 =new JCheckBox("Email And SMS Alerts");
        s4.setBackground(Color.WHITE);
        s4.setFont(new Font("Raleway",Font.BOLD,16));
        s4.setBounds(350,550,250,30);
        add(s4);

        s5 =new JCheckBox("Cheque Book");
        s5.setBackground(Color.WHITE);
        s5.setFont(new Font("Raleway",Font.BOLD,16));
        s5.setBounds(100,600,200,30);
        add(s5);

        s6 =new JCheckBox("E-Statement");
        s6.setBackground(Color.WHITE);
        s6.setFont(new Font("Raleway",Font.BOLD,16));
        s6.setBounds(350,600,200,30);
        add(s6);

        s7 =new JCheckBox("I HearBy Declair The Above Enter Details are Correct By the Best OF My Knowledge");
        s7.setBackground(Color.WHITE);
        s7.setFont(new Font("Raleway",Font.BOLD,12));
        s7.setBounds(100,680,600,30);
        add(s7);

        Submit=new JButton("Submit");
        Submit.setBounds(250,720,100,35);
        Submit.setForeground(Color.BLUE);
        Submit.setFont(new Font("Arial", Font.BOLD, 15));
        Submit.addActionListener(this);
        add(Submit);

        Cancel=new JButton("Cancel");
        Cancel.setBounds(420,720,100,35);
        Cancel.setForeground(Color.RED);
        Cancel.setFont(new Font("Arial", Font.BOLD, 15));
        Cancel.addActionListener(this);
        add(Cancel);


        setSize(800,830);
        setVisible(true);

        getContentPane().setBackground(Color.white);

        setLocation(390,160);
    }
    public static void main(String[] args) {
        new SignUpThree();
    }

    public void actionPerformed(ActionEvent ac){
        long FormNo=SignUpOne.Rnd;
        if(ac.getSource()==Submit){
            String AccountType="Null";
            if (r1.isSelected()){
                AccountType="Saving";
            } else if (r2.isSelected()) {
                AccountType="Fix Deposit Account";
            }else if (r3.isSelected()) {
                AccountType="Current";
            } else if (r4.isSelected()) {
                AccountType="Requiring Deposit Account";
            }

            Random random=new Random();
            cardNumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);

            pinNumber=""+Math.abs((random.nextLong()%9000L)+1000L);

            String facility="";
            String terms="";
            if(s1.isSelected()){
                facility+="/ATM CARD/";
            }if (s2.isSelected()) {
                facility+="/Internet Banking/";
            }if (s3.isSelected()) {
                facility+="/Mobile Banking/";
            }if (s4.isSelected()) {
                facility+="/Email And SMS Services/";
            }if (s5.isSelected()) {
                facility+="/Cheque Book/";
            }if (s6.isSelected()) {
                facility+="/E-Statement/";
            }if (s7.isSelected()){
                terms="Verified";
            }


            try {
                if(AccountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type IS Required");
                }if (terms.equals("")) {
                    JOptionPane.showMessageDialog(null,"PLZ Select The Terms And Conditions");
                } else {
                    Con c=new Con();
                    String query= "insert into signupThree values('"+FormNo+"','"+AccountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query1= "insert into Login values('"+cardNumber+"','"+pinNumber+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);

                    JOptionPane.showMessageDialog(null,"Card Number: "+cardNumber+"\n"+"PIN: "+pinNumber);

                    setVisible(false);
                    new Login().setVisible(true);
                }
            } catch (Exception ec) {
                System.out.println(ec);
            }

        } else if (ac.getSource()==Cancel) {
            System.exit(0);
        }
    }
}

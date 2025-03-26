import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverAction;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash  extends JFrame implements ActionListener {

    JButton Hundred, FiveHundred,OneThousand, TwoThousand, FiveThousand, TenThousand,Back;
    String pinNumber;

    FastCash(String pinNumber) {

        this.pinNumber = pinNumber;

        setTitle("ATM Machine");

        setLayout(null);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel label = new JLabel(I3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel AtmLabel = new JLabel("Select The Withdrawal Amount");
        AtmLabel.setFont(new Font("System", Font.BOLD, 16));
        AtmLabel.setForeground(Color.WHITE);
        AtmLabel.setBounds(220, 300, 700, 35);
        label.add(AtmLabel);

        Hundred = new JButton("Rs 100");
        Hundred.setBounds(170, 415, 150, 33);
        Hundred.addActionListener(this);
        label.add(Hundred);

        FiveHundred = new JButton("Rs 500");
        FiveHundred.setBounds(355, 415, 150, 33);
        FiveHundred.addActionListener(this);
        label.add(FiveHundred);

        OneThousand = new JButton("Rs 1000");
        OneThousand.setBounds(170, 450, 150, 33);
        OneThousand.addActionListener(this);
        label.add(OneThousand);

        TwoThousand = new JButton("Rs 2000");
        TwoThousand.setBounds(355, 450, 150, 33);
        TwoThousand.addActionListener(this);
        label.add(TwoThousand);

        FiveThousand= new JButton("Rs 5000");
        FiveThousand.setBounds(170, 485, 150, 33);
        FiveThousand.addActionListener(this);
        label.add(FiveThousand);

        TenThousand = new JButton("Rs 10000");
        TenThousand.setBounds(355, 485, 150, 33);
        TenThousand.addActionListener(this);
        label.add(TenThousand);

        Back = new JButton("Back");
        Back.setBounds(355, 520, 150, 33);
        Back.addActionListener(this);
        label.add(Back);

        setSize(900, 840);
        setLocation(350, 100);

        setUndecorated(true);

        setVisible(true);

    }

    public static void main(String[] args) {
        new FastCash("");
    }

    public void actionPerformed(ActionEvent ae) {
        String AmountGet;
        if (ae.getSource() == Back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        } else  {
            AmountGet=((JButton)ae.getSource()).getText().substring(3);
            Con c =new Con();
            try {
                ResultSet rs=c.s.executeQuery("Select * from Bank where PIN = '"+pinNumber+"'");
                int balance=0;
                while (rs.next()){
                    if(rs.getString("Type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("Amount"));
                    }else {
                        balance-=Integer.parseInt(rs.getString("Amount"));
                    }
                }

                if (ae.getSource()!= Back && balance<Integer.parseInt(AmountGet)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                }else {
                    Date date=new Date();
                    String query="insert into Bank values('"+pinNumber+"','"+date+"','Withdraw','"+AmountGet+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+AmountGet+" Debited Successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
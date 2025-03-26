import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton Back;
    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;

        setLayout(null);

        ImageIcon I1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I3= new ImageIcon(I2);
        JLabel label=new JLabel(I3);
        label.setBounds(0,0,900,900);
        add(label);

        Back=new JButton("Back");
        Back.setBounds(355,520,150,33);
        Back.addActionListener(this);
        label.add(Back);

        Con c =new Con();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("Select * from Bank where PIN = '" + pinNumber+ "'");
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel Balance = new JLabel("Your Current Account Balance  ");
        Balance.setFont(new Font("System", Font.BOLD, 16));
        Balance.setForeground(Color.WHITE);
        Balance.setBounds(205, 300, 700, 35);
        label.add(Balance);

        JLabel BalancePr = new JLabel("Rs "+balance);
        BalancePr.setFont(new Font("System", Font.BOLD, 18));
        BalancePr.setForeground(Color.WHITE);
        BalancePr.setBounds(205, 350, 700, 35);
        label.add(BalancePr);

        setSize(900,840);
        setLocation(350,100);

        setUndecorated(true);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinNumber).setVisible(true);
    }
}

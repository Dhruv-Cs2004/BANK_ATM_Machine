import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField Amount;
    JButton Withdraw,Back;
    String pinNumber;
    Withdrawal(String pinNumber){
        this.pinNumber=pinNumber;

        setTitle("ATM Machine");

        setLayout(null);

        ImageIcon I1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I3= new ImageIcon(I2);
        JLabel label=new JLabel(I3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel AtmLabelDepo = new JLabel("Enter The Amount You Want To Withdraw");
        AtmLabelDepo.setFont(new Font("System",Font.BOLD,15));
        AtmLabelDepo.setForeground(Color.WHITE);
        AtmLabelDepo.setBounds(180,300,700,35);
        label.add(AtmLabelDepo);

        Amount = new JTextField();
        Amount.setFont(new Font("Raleway",Font.BOLD,14));
        Amount.setBounds(175,360,320,25);
        label.add(Amount);

        Withdraw=new JButton("Withdraw Amount");
        Withdraw.setBounds(355,485,150,33);
        Withdraw.addActionListener(this);
        label.add(Withdraw);

        Back=new JButton("Go Back");
        Back.setBounds(355,520,150,33);
        Back.addActionListener(this);
        label.add(Back);

        setSize(900,840);
        setLocation(350,100);

        setUndecorated(true);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Withdrawal("");;
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Withdraw){
            String Number =Amount.getText();
            Date date=new Date();
            if(Number.equals("")){
                JOptionPane.showMessageDialog(null,"PLz Enter The Amount You Want To  Withdraw");
            }else {
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

                    if (ae.getSource()!= Back && balance<Integer.parseInt(Number)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    }else {
                        String query="insert into Bank values('"+pinNumber+"','"+date+"','Withdraw','"+Number+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs"+Number+" Debited Successfully");
                        setVisible(false);
                        new Transaction(pinNumber).setVisible(true);
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource()==Back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
}

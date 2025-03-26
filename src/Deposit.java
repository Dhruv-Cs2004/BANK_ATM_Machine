import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField Amount;
    JButton DepositAm,Back;
    String pinNumber;
    Deposit(String pinNumber){
        this.pinNumber=pinNumber;

        setTitle("ATM Machine");

        setLayout(null);

        ImageIcon I1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I3= new ImageIcon(I2);
        JLabel label=new JLabel(I3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel AtmLabelDepo = new JLabel("Enter The Amount You Want To Deposit");
        AtmLabelDepo.setFont(new Font("System",Font.BOLD,15));
        AtmLabelDepo.setForeground(Color.WHITE);
        AtmLabelDepo.setBounds(180,300,700,35);
        label.add(AtmLabelDepo);

        Amount = new JTextField();
        Amount.setFont(new Font("Raleway",Font.BOLD,14));
        Amount.setBounds(175,360,320,25);
        label.add(Amount);

        DepositAm=new JButton("Deposit Amount");
        DepositAm.setBounds(355,485,150,33);
        DepositAm.addActionListener(this);
        label.add(DepositAm);

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
       new Deposit("");;
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==DepositAm){
            String Number =Amount.getText();
            Date date=new Date();
            if(Number.equals("")){
                JOptionPane.showMessageDialog(null,"PLz Enter The Amount");
            }else {
                try {
                    Con con=new Con();
                    String Query="Insert into Bank values ('"+pinNumber+"','"+date+"','Deposit','"+Number+"')";
                    con.s.executeUpdate(Query);
                    JOptionPane.showMessageDialog(null,"Rs"+Number+" Deposit Successful");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);

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

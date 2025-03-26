import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction  extends JFrame implements ActionListener {

    JButton Deposit,Withdrawal,FetchCash,MinStatement,PinChange,BalanceEq,Exit;
    String pinNumber;
    Transaction(String pinNumber){

        this.pinNumber=pinNumber;

        setTitle("ATM Machine");

        setLayout(null);

        ImageIcon I1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I3= new ImageIcon(I2);
        JLabel label=new JLabel(I3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel AtmLabel = new JLabel("PLZ Select your Transaction");
        AtmLabel.setFont(new Font("System",Font.BOLD,16));
        AtmLabel.setForeground(Color.WHITE);
        AtmLabel.setBounds(220,300,700,35);
        label.add(AtmLabel);

        Deposit=new JButton("Deposit");
        Deposit.setBounds(170,415,150,33);
        Deposit.addActionListener(this);
        label.add(Deposit);

        Withdrawal=new JButton("Withdrawal");
        Withdrawal.setBounds(355,415,150,33);
        Withdrawal.addActionListener(this);
        label.add(Withdrawal);

        FetchCash=new JButton("Fast Cash");
        FetchCash.setBounds(170,450,150,33);
        FetchCash.addActionListener(this);
        label.add(FetchCash);

        MinStatement=new JButton("Mini Statement");
        MinStatement.setBounds(355,450,150,33);
        MinStatement.addActionListener(this);
        label.add(MinStatement);

        PinChange=new JButton("PIN Change");
        PinChange.setBounds(170,485,150,33);
        PinChange.addActionListener(this);
        label.add(PinChange);

        BalanceEq=new JButton("Balance Enquiry");
        BalanceEq.setBounds(355,485,150,33);
        BalanceEq.addActionListener(this);
        label.add(BalanceEq);

        Exit=new JButton("Exit");
        Exit.setBounds(355,520,150,33);
        Exit.setForeground(Color.RED);
        Exit .addActionListener(this);
        label.add(Exit);

        setSize(900,840);
        setLocation(350,100);

        setUndecorated(true);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Transaction("");
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Exit){
            System.exit(0);
        } else if (ae.getSource()==Deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource()==Withdrawal) {
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        } else if (ae.getSource()==FetchCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (ae.getSource()==PinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (ae.getSource()==BalanceEq) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if (ae.getSource()==MinStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
}
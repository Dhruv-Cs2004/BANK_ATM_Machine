import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JButton login,Clear,SignUp;
    JTextField Card;
    JPasswordField UserPin;
    Login(){
        setTitle("ATM");

        setLayout(null);

        ImageIcon I1 =new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image I2 = I1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon I3= new ImageIcon(I2);
        JLabel label=new JLabel(I3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel CardNo=new JLabel("Card No:");
        CardNo.setFont(new Font("Railway",Font.BOLD,28));
        CardNo.setBounds(120,150,400,40);
        add(CardNo);

        Card=new JTextField();
        Card.setBounds(300,150,250,40);
        Card.setFont(new Font("Arial",Font.BOLD,14));
        add(Card);

        JLabel Pin=new JLabel("PIN:");
        Pin.setFont(new Font("Railway",Font.BOLD,28));
        Pin.setBounds(120,220,400,40);
        add(Pin);

        UserPin=new JPasswordField();
        UserPin.setBounds(300,220,250,40);
        add(UserPin);

        login=new JButton("SIGN.IN");
        login.setBounds(300,300,100,35);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.setFont(new Font("Arial", Font.BOLD, 15));
        login.addActionListener(this);
        add(login);

        Clear=new JButton("Clear");
        Clear.setBounds(430,300,100,35);
        Clear.setBackground(Color.WHITE);
        Clear.setForeground(Color.BLACK);
        Clear.setFont(new Font("Arial", Font.BOLD, 17));
        Clear.addActionListener(this);
        add(Clear);

        SignUp=new JButton("SIGN UP");
        SignUp.setBounds(300,350,230,35);
        SignUp.setBackground(Color.WHITE);
        SignUp.setForeground(Color.BLACK);
        SignUp.setFont(new Font("Arial", Font.BOLD, 15));
        SignUp.addActionListener(this);
        add(SignUp);


        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);

        setLocation(350,280);

    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==login){
            String cardNumber= Card.getText();
            String pinNumber = UserPin.getText();
            String Query="Select * From Login where cardNumber ='"+cardNumber+"'and Pin = '"+pinNumber+"'";
            try {
                Con cal=new Con();
                ResultSet rs=cal.s.executeQuery(Query);
                if (rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Wrong EmailId Or PIN");
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (e.getSource()==Clear) {
            Card.setText("");
            UserPin.setText("");
        } else if (e.getSource()==SignUp) {
            setVisible(false);
            new SignUpOne().setVisible(true);

        }
    }
}
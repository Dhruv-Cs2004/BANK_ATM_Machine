import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String PinNumber;
    JPasswordField NewPin,RePin;
    JButton Change,Back;
    PinChange(String PinNumber){
        this.PinNumber=PinNumber;

        setLayout(null);

        ImageIcon I1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon I3= new ImageIcon(I2);
        JLabel label=new JLabel(I3);
        label.setBounds(0,0,900,900);
        add(label);

        JLabel AtmLabelPin = new JLabel("Change Your PIN");
        AtmLabelPin.setFont(new Font("System",Font.BOLD,18));
        AtmLabelPin.setForeground(Color.WHITE);
        AtmLabelPin.setBounds(250,280,500,35);
        label.add(AtmLabelPin);

        JLabel AtmLabelPinNe = new JLabel("Enter Your PIN");
        AtmLabelPinNe.setFont(new Font("System",Font.BOLD,15));
        AtmLabelPinNe.setForeground(Color.WHITE);
        AtmLabelPinNe.setBounds(165,325,180,25);
        label.add(AtmLabelPinNe);

        NewPin= new JPasswordField();
        NewPin.setFont(new Font("Raleway",Font.BOLD,14));
        NewPin.setBounds(330,325,180,25);
        label.add(NewPin);


        JLabel AtmLabelPinRe = new JLabel("Re-Enter Your PIN");
        AtmLabelPinRe.setFont(new Font("System",Font.BOLD,15));
        AtmLabelPinRe.setForeground(Color.WHITE);
        AtmLabelPinRe.setBounds(165,365,180,25);
        label.add(AtmLabelPinRe);

        RePin= new JPasswordField();
        RePin.setFont(new Font("Raleway",Font.BOLD,14));
        RePin.setBounds(330,365,180,25);
        label.add(RePin);

        Change=new JButton("Change PIN");
        Change.setBounds(355,485,150,33);
        Change.addActionListener(this);
        label.add(Change);

        Back=new JButton("Back");
        Back.setBounds(355,520,150,33);
        Back.addActionListener(this);
        label.add(Back);


        setSize(900,840);
        setLocation(350,100);

        setUndecorated(true);

        setVisible(true);
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Back){
            setVisible(false);
            new Transaction(PinNumber).setVisible(true);
        }else if(ae.getSource()==Change) {
            try {
                String nPin= NewPin.getText();
                String rPin = RePin.getText();
                if(!nPin.equals(rPin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN Dose Not Match" );
                }else {
                    if (nPin.equals("")){
                        JOptionPane.showMessageDialog(null,"PLZ Enter New The Pin " );
                    }else {
                        Con c=new Con();
                        String query1 = "update Bank set PIN ='"+rPin+"' where PIN='"+PinNumber+"'";
                        String query2 = "update signupThree set Pin ='"+rPin+"' where Pin='"+PinNumber+"'";
                        String query3 = "update Login set Pin ='"+rPin+"' where Pin='"+PinNumber+"'";

                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);
                        c.s.executeUpdate(query3);

                        JOptionPane.showMessageDialog(null,"PIN Change Successfully " );

                        setVisible(false);
                        new Transaction(PinNumber).setVisible(true);

                    }
                }


            } catch (Exception ea) {
                System.out.println(ea);
            }
        }
    }
}

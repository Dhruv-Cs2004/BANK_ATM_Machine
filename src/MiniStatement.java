import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber=pinNumber;
        setTitle("ATM Machine");

        setLayout(null);

        JLabel Bank = new JLabel("Indian Bank");
        Bank.setFont(new Font("System", Font.BOLD, 16));
        Bank.setBounds(150,20,100,20);
        add(Bank);

        JLabel Balance = new JLabel();
        Balance.setFont(new Font("System", Font.BOLD, 13));
        Balance.setBounds(20,400,300,30);
        add(Balance);

        JLabel Card = new JLabel();
        Card.setFont(new Font("System", Font.BOLD, 13));
        Card.setBounds(20,80,500,20);
        add(Card);

        JLabel Mini = new JLabel();
        Mini.setFont(new Font("System", Font.BOLD, 13));
        Mini.setBounds(20,140,400,198);
        add(Mini);

        Con c=new Con();
        try {
            ResultSet rs= c.s.executeQuery("SELECT * FROM Login WHERE Pin = '"+pinNumber+"'");
            while (rs.next()){
                Card.setText("Card Number: "+ rs.getString("CardNumber").substring(0,4)+"XXXXXXXX"+ rs.getString("CardNumber").substring(12));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        int bal=0;
        try {
            ResultSet rs= c.s.executeQuery("SELECT * FROM Bank WHERE PIN = '"+pinNumber+"'");
            while (rs.next()){
                Mini.setText(Mini.getText()+"<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"<br><br><html>");
                if(rs.getString("Type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("Amount"));
                }else {
                    bal-=Integer.parseInt(rs.getString("Amount"));
                }
            }
            Balance.setText("Your Current Account Balance is Rs "+bal);


        } catch (Exception ex) {
            System.out.println(ex);
        }


        setSize(400, 600);
        setLocation(340, 170);

        getContentPane().setBackground(Color.white);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}

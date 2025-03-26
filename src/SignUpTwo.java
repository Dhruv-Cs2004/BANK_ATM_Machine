import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignUpTwo extends JFrame implements ActionListener {

    JComboBox religion,category,income,education,occupation;
    JTextField pan,aadharNo;
    JRadioButton Yes,No,existingAc,NonExistingAc;
    JButton Next;
    SignUpTwo(){
        setTitle("Page Additional Details");

        setLayout(null);

        JLabel Second = new JLabel("Page 2: Additional Details");
        Second.setFont(new Font("Raleway",Font.BOLD,28));
        Second.setBounds(280,80,400,30);
        add(Second);

        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(180,140,100,30);
        add(Religion);

        String ValReligion[]={"Hindu","Sikh","Christian","Muslim", "Other"};
        religion =new JComboBox(ValReligion);
        religion.setBounds(400,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(180,190,150,30);
        add(Category);

        String ValCategory[]={"General","OBC","SC","ST", "Other"};
        category =new JComboBox(ValCategory);
        category.setBounds(400,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(180,240,200,30);
        add(Income);

        String ValIncome[]={"Null","< 1,50,000","> 2,50,000","<5,00,00", "Up To 10,00,000"};
        income =new JComboBox(ValIncome);
        income.setBounds(400,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel Education = new JLabel("Education:");
        Education.setFont(new Font("Raleway",Font.BOLD,20));
        Education.setBounds(180,290,200,30);
        add(Education);

        String ValEducation[]={"Non-Graduation","Graduation","Post Graduation","Doctorate", "Other"};
        education =new JComboBox(ValEducation);
        education.setBounds(400,290,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(180,340,200,30);
        add(Occupation);

        String ValOccupation[]={"Salaried","Self-Employed","Business","Student", "Retired","Other"};
        occupation =new JComboBox(ValOccupation);
        occupation.setBounds(400,340,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel PAN = new JLabel("PAN No:");
        PAN.setFont(new Font("Raleway",Font.BOLD,20));
        PAN.setBounds(180,390,200,30);
        add(PAN);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(400,390,400,30);
        add(pan);

        JLabel AadharNo = new JLabel("Aadhar No:");
        AadharNo.setFont(new Font("Raleway",Font.BOLD,20));
        AadharNo.setBounds(180,440,200,30);
        add(AadharNo);

        aadharNo = new JTextField();
        aadharNo.setFont(new Font("Raleway",Font.BOLD,14));
        aadharNo.setBounds(400,440,400,30);
        add(aadharNo);

        JLabel SeniorCt = new JLabel("Senior Citizen:");
        SeniorCt.setFont(new Font("Raleway",Font.BOLD,20));
        SeniorCt.setBounds(180,490,200,30);
        add(SeniorCt);

        Yes = new JRadioButton("Yes");
        Yes.setBounds(400,490,100,30);
        add(Yes);

        No = new JRadioButton("No");
        No.setBounds(580,490,100,30);
        add(No);

        ButtonGroup Groups=new ButtonGroup();
        Groups.add(Yes);
        Groups.add(No);

        JLabel ExistingAC = new JLabel("Existing Account:");
        ExistingAC.setFont(new Font("Raleway",Font.BOLD,20));
        ExistingAC.setBounds(180,540,200,30);
        add(ExistingAC);

        existingAc = new JRadioButton("Existing Account");
        existingAc.setBounds(400,540,150,30);
        add(existingAc);

        NonExistingAc = new JRadioButton("Non Existing Account");
        NonExistingAc.setBounds(580,540,170,30);
        add(NonExistingAc);

        ButtonGroup Groups1=new ButtonGroup();
        Groups1.add(existingAc);
        Groups1.add(NonExistingAc);

        Next=new JButton("Next");
        Next.setBounds(620,660,100,35);
        Next.setForeground(Color.BLUE);
        Next.setFont(new Font("Arial", Font.BOLD, 15));
        Next.addActionListener(this);
        add(Next);

        setSize(850 ,800);
        setVisible(true);

        getContentPane().setBackground(Color.white);

        setLocation(390,160);
    }

    public static void main(String[] args) {
        new SignUpTwo();
    }

    public void actionPerformed(ActionEvent ac){
        String FormNo=""+ SignUpOne.Rnd;
        String religionGet=(String) religion.getSelectedItem();
        String incomeGet=(String) income.getSelectedItem();
        String educationGet=(String) education.getSelectedItem();
        String occupationGet=(String) occupation.getSelectedItem();
        String panGet =(String) pan.getText();
        String aadharNoGet=(String) aadharNo.getText();
        String Senior="null";
        if(Yes.isSelected()){
            Senior="Yes";
        }else {
            Senior="No";
        }
        String Account="null";
        if (existingAc.isSelected()){
            Account="Already Have Account";
        }else {
            Account="Not Have Account";
        }

        try {
            if(panGet.isEmpty()){
                JOptionPane.showMessageDialog(null,"PAN No Required");
            } else if (aadharNoGet.isEmpty()) {
                JOptionPane.showMessageDialog(null,"AadharNo Required");
            }else {
                Con c=new Con();
                String query= "insert into signupSecond values('"+FormNo+"','"+religionGet+"','"+incomeGet+"','"+educationGet+"','"+occupationGet+"','"+panGet+"','"+aadharNoGet+"','"+Senior+"','"+Account+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                SignUpThree cal=new SignUpThree();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class frame5 extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3,t4,t5;
    
    frame5(String un)
    {
        setSize(790,700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Siddharth Malhotra\\Documents\\NetBeansProjects\\Banking Security\\Security.jpg")));
        setLayout(new FlowLayout());
	setTitle("Welcome-AARS BANK");
	setLayout(null);
	setVisible(true);
	setSize(790,700);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
        b1=new JButton("Logout");
        b1.setBounds(600,60,75,30);
        add(b1);
        b2=new JButton("Profile");
        b2.setBounds(680,60,75,30);
        add(b2);
        l1=new JLabel(un);
        l1.setFont(new Font("junction regular",Font.BOLD,15));
        l1.setBounds(685,30,75,30);
        add(l1);
        
        l2=new JLabel("Welcome,");
        l2.setFont(new Font("junction regular",Font.BOLD,15));
        l2.setBounds(615,30,100,30);
        add(l2);
        
        b4=new JButton("Apply");
        b4.setFont(new Font("junction regular",Font.BOLD,18));
        b4.setBounds(290,140,120,30);
        add(b4);
        
        b5=new JButton("Last Transactions");
        b5.setFont(new Font("junction regular",Font.BOLD,18));
        b5.setBounds(420,140,200,30);
        add(b5);
        
        l3=new JLabel("The service is currently unavailable.");
        l3.setBounds(290,250,220,30);
        add(l3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        String s=e.getActionCommand();
        if(s.equals("Apply"))
        {
            new frame8();
            dispose();
          //  JOptionPane.showMessageDialog(null,"Kindly contact us at 0172-2848284 to apply.","Message",JOptionPane.INFORMATION_MESSAGE);
        }
        if(s.equals("Profile"))
        {
            JOptionPane.showMessageDialog(null,"Under Construction.","Message",JOptionPane.INFORMATION_MESSAGE);
        }
        if(s.equals("Logout"))
        {
            dispose();
            new frame1();
        }
        if(s.equals("Last Transactions"))
        {
            JOptionPane.showMessageDialog(null,"Under Construction.","Message",JOptionPane.INFORMATION_MESSAGE);
        }
        if(s.equals("Apply"))
        {
            new frame8();
            dispose();
          //  JOptionPane.showMessageDialog(null,"Kindly contact us at 0172-2848284 to apply.","Message",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
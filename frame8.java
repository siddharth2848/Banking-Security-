import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class frame8 extends JFrame implements ActionListener
{
        JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	JTextField t1,t2,t3;
        JTextArea tb1,tb2;
	JPasswordField p1,p2;
        frame8()
        {
            
            System.out.println("otp");
             setSize(790,700);
      setLocationRelativeTo(null);
            setTitle("Apply-AARS BANK");
            setLayout(null);
	setVisible(true);         
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setBackground(Color.WHITE);
        
       l1=new JLabel("Name");
       l1.setBounds(50,140,69,30);
       add(l1);
       l2=new JLabel("Income");
       l2.setBounds(50,180,69,30);
       add(l2); 
       
       t1=new JTextField();
       t1.setBounds(140,140,90,30);
       add(t1);
       
       t2=new JTextField();
       t2.setBounds(140,180,90,30);
       add(t2);
       
       b1=new JButton("Submit");
       b1.setBounds(200,230,90,30);
       add(b1);
       
        b1.addActionListener(this);
//        b2.addActionListener(this);
        }
        
        public void actionPerformed(ActionEvent e)
        {
        //    frame7 obj=new frame7();
             String s=e.getActionCommand();
            if(s.equals("Submit"))
            {
                
                
                JOptionPane.showMessageDialog(null,"We have received your request.We will contact you shortly.","Message",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
}

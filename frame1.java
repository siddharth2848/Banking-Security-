import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Siddharth Malhotra
 */
public class frame1 extends JFrame implements ActionListener
{
    
    JButton b1,b2;
    JLabel l1;

frame1()
  {
        setSize(790,700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Siddharth Malhotra\\Documents\\NetBeansProjects\\Banking Security\\Security.jpg")));
        setLayout(new FlowLayout());
	setTitle("NetSafe-AARS BANK");
	setLayout(null);
	setVisible(true);
	setSize(790,700);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	l1=new JLabel("AARS BANK");
	l1.setBounds(84,60,590,260);
	l1.setFont(new Font("Fontin Bold",Font.BOLD,70));
	l1.setForeground(Color.RED);            //font color
	add(l1);                                //show on window

	b1=new JButton("Sign Up");
	b1.setBounds(100,400,250,100);
	b1.setFont(new Font("junction regular",Font.BOLD,50));
	b1.setForeground(Color.BLUE);
	add(b1);

	b2=new JButton("Login");
	b2.setBounds(470,400,200,100);
	b2.setFont(new Font("junction regular",Font.BOLD,50));
	b2.setForeground(Color.BLUE);
	add(b2);
	b1.addActionListener(this);                 //button click
	b2.addActionListener(this);
	}

    @Override
	public void actionPerformed(ActionEvent e)
  {
    String s=e.getActionCommand();
	if(s.equals("Sign Up"))
    {
      dispose();                    //closes previous frame
	 new frame2();             //object created of next frame
    }
	if(s.equals("Login"))
    {
      dispose();
	  new frame3();
    }
  }

	public static void main(String []arg)       //main function
	{
	frame1 obj=new frame1();                //object of main window
	}
}

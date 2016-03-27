import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class frame3 extends JFrame implements ActionListener
{
        JLabel l1,l2,l3;
	JButton b1,b2,b3;
	JTextField t1;
	JPasswordField p1;
        int i=0;
	frame3()
	{
	setTitle("Login-AARS BANK");
	
	 setSize(790,700);
      setLocationRelativeTo(null);
	
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Siddharth Malhotra\\Documents\\NetBeansProjects\\Banking Security\\Security.jpg")));
        setLayout(new FlowLayout());
	setLayout(null);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setBackground(Color.WHITE);
        
        b3=new JButton("Home");
        add(b3);
        b3.setFont(new Font("junction regular",Font.BOLD,20));
        b3.setBounds(670,20,95,30);
	
	l3=new JLabel("AARS BANK");
	l3.setBounds(84,60,590,260);
	l3.setFont(new Font("Fontin Bold",Font.BOLD,70));
	l3.setForeground(Color.BLACK);
	add(l3);
	
	t1=new JTextField();
	t1.setBounds(300,330,300,30);
	add(t1);
	
	p1=new JPasswordField();
	p1.setBounds(300,380,300,30);
        p1.setTransferHandler(null);
        p1.addKeyListener(new KeyWork());
	add(p1);
	
	l1=new JLabel("User Name");
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("junction regular",Font.BOLD,25));
	l1.setBounds(45,330,150,30);
	add(l1);
	
	
        l2=new JLabel("Password");
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("junction regular",Font.BOLD,25));
	l2.setBounds(45,380,150,30);
	add(l2);
	
	b1=new JButton("Login");
	b1.setBounds(200,450,100,50);
	add(b1);
	
	b2=new JButton("Forgot Password");
	b2.setBounds(310,450,160,50);
	add(b2);
	
	b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
	}
        
        private class KeyWork extends KeyAdapter
    {
        public void keyPressed(KeyEvent k)
        {
             if (((k.getModifiers() & ActionEvent.CTRL_MASK) ==ActionEvent.CTRL_MASK)&&(k.getKeyCode() == KeyEvent.VK_C)) {
System.out.println("CTRL KEY PRESSED");

            
                JOptionPane.showMessageDialog(null,"Copy function disabled","Message",JOptionPane.ERROR_MESSAGE);
            }
            
            if (((k.getModifiers() & ActionEvent.CTRL_MASK) ==ActionEvent.CTRL_MASK)&&(k.getKeyCode() == KeyEvent.VK_V)) {
System.out.println("CTRL KEY PRESSED");

            
                JOptionPane.showMessageDialog(null,"Paste function disabled","Message",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        
        
        
        @Override
	public void actionPerformed(ActionEvent e)
	{
	String s=e.getActionCommand();
        
        if(s.equals("Forgot Password"))
        {
            dispose();
            new frame4();
        }
        
	if(s.equals("Login"))
	{
	String un= t1.getText();
		String pd=p1.getText();

        Connection conn = null;
		Statement stmt = null;
		try
		{
                    i=0;
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			conn = DriverManager.getConnection("Jdbc:Odbc:emp");
			if (conn != null)
			{	
				stmt=conn.createStatement();
				String query = "SELECT * FROM BookMaster89";
				ResultSet  rs = stmt.executeQuery(query);
				while (rs.next())
				{
                                    String	b= rs.getString("Username");
                                    String	c= rs.getString("Password");
				if(un.equals(b)&&pd.equals(c))
					{
        dispose();
    new frame5(un);break;
	  }
     else
	  {
              i++;
	  }
	}
                                if(i!=0)
                                    JOptionPane.showMessageDialog(null,"User doesnot exists.","Message",JOptionPane.ERROR_MESSAGE);
                                    
  }
  conn.close();
		}
		catch (Exception me)
		{
			System.err.println ("Cannot connect to database server"+me);
		}
	}
        if(s.equals("Home"))
        {
            dispose();
            new frame1();
        }
	}
}
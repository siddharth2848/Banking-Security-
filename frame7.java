import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class frame7 extends JFrame implements ActionListener
{
        JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	JTextField t1,t2,t3;
        JTextArea tb1,tb2;
	JPasswordField p1,p2;
        int i=0;
        int otp;
        String username;
        frame7(String un,int otp)
        {
            
          //  System.out.println(otp);
             setSize(790,700);
      setLocationRelativeTo(null);
            setTitle("Recover Password-AARS BANK");
            setLayout(null);
	setVisible(true);         
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setBackground(Color.WHITE);
        
        p1=new JPasswordField();
        add(p1);
        p1.setBounds(383,450,300,30);
        
        username=un;
       
        t3=new JTextField();
        t3.setBounds(300,390,300,30);
        
        String b=Integer.toString(otp);
        t3.setText(b);
        System.out.println("t3:"+b);
        
        p2=new JPasswordField();
        add(p2);
        p2.setBounds(383,500,300,30);
        
        t2=new JTextField();
        t2.setBounds(300,390,300,30);
        add(t2);
        
        l3=new JLabel("OTP");
        l3.setBounds(45,390,230,30);
        add(l3);
        
        l4=new JLabel("New Password");
        add(l4);
        l4.setBounds(45,450,230,30);
        
        l5=new JLabel("Confirm New Password");
        add(l5);
        l5.setBounds(45,500,230,30);
        
        b2=new JButton("Submit");
        b2.setBounds(45,580,80,50);
        add(b2);
        
        b1=new JButton("Home");
        add(b1);
        b1.setFont(new Font("junction regular",Font.BOLD,20));
        b1.setBounds(670,20,95,30);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        }
        
        public void actionPerformed(ActionEvent e)
        {
        //    frame7 obj=new frame7();
             String s=e.getActionCommand();
            if(s.equals("Home"))
            {
                dispose();
                new frame1();
                
            }
            
           
            if(s.equals("Submit"))
            {
            String b;
                int otp=Integer.parseInt(t3.getText());
                int otp_text=Integer.parseInt(t2.getText());
            //    System.out.println(otp_generated);
              //  int otp=Integer.parseInt(t3.getText());
              //  System.out.println("otp_text:"+otp);
                //System.out.println("otp_gen:"+otp_generated);
      
                if(otp==otp_text)
        {
             String p3=p1.getText();
              String p4=p2.getText();
        //     System.out.println(p1.getText());System.out.println(p2.getText());
            if(!p3.equals(p4))
            {
                JOptionPane.showMessageDialog(null,"Password donot match.","Message",JOptionPane.ERROR_MESSAGE);
            }//break;
            else{
            String p=p1.getText();
          //  System.out.println("done");
//                username=t1.getText();
            
                if(p.length()> 6 && p.length()<16)
                {
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
                                    b= rs.getString(1);
			if(username.equals(b))
                                {
                                    
                 PreparedStatement pst = conn.prepareStatement("update BookMaster89 SET Password=? WHERE Username=?");
           pst.setString(1, p1.getText());
         pst.setString(2, username);
                            pst.executeUpdate();        
                               JOptionPane.showMessageDialog(null,"Password successfully updated.","Message",JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                                  rs.close();
                                   break;
                                }
                             
	}
                                if(i!=0)
                       JOptionPane.showMessageDialog(null,"Invalid Username.","Message",JOptionPane.ERROR_MESSAGE);
  
                        rs.close();
                        }
                        dispose();
                        new frame1();
                
  conn.close();
  stmt.close();
		}
		catch (Exception me)
		{
			//me.printStackTrace();
		}
        // rs.close();
        // stmt.close();
            }
                else
                {
                    JOptionPane.showMessageDialog(null,"Password should be of characters 7 to 16.","Message",JOptionPane.ERROR_MESSAGE);

                }
            }
            
        }
         
        
                
                else
        {
            
            JOptionPane.showMessageDialog(null,"Invalid OTP entered.","Message",JOptionPane.ERROR_MESSAGE);
        }
                
            }
        
        }
}

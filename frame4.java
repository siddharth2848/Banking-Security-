import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Collections;
import java.util.Random;

class frame4 extends JFrame implements ActionListener
{
        JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3;
	JTextField t1,t2,t3;
        JTextArea tb1,tb2;
	JPasswordField p1,p2;
        int i=0;
        static int otp_generated=0;
        String email;
        
        frame4()
        {
             setSize(790,700);
      setLocationRelativeTo(null);
            setTitle("Forgot Password-AARS BANK");
            setLayout(null);
	setVisible(true);         
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setBackground(Color.WHITE);
        
        l1=new JLabel("AARS BANK");
	l1.setBounds(84,60,590,260);
	l1.setFont(new Font("Fontin Bold",Font.BOLD,70));
	l1.setForeground(Color.RED);
	add(l1);
        
        t1=new JTextField();
	t1.setBounds(300,290,300,30);
	add(t1);
        
        l2=new JLabel("User Name");
	l2.setBounds(45,290,100,30);
	add(l2);
        
        b1=new JButton("Generate OTP");
	b1.setBounds(145,342,150,30);
	add(b1);
        
        b3=new JButton("Home");
        add(b3);
        b3.setFont(new Font("junction regular",Font.BOLD,20));
        b3.setBounds(670,20,95,30);
                
         b1.addActionListener(this);
        b3.addActionListener(this);
        }
        
                   public  int randomNumberGenerator()
{
int num = -1;

ArrayList<Integer> arNumber = new ArrayList<Integer>();
for(int x = 0; x <10; x++)
{
    arNumber.add(x);
}
Collections.shuffle(arNumber);
String strNum;
do{
strNum = "";

for(int i = 0; i <4; i++)
    strNum = strNum + arNumber.get(new Random().nextInt(10));
}while(strNum.length()!=4);
num = Integer.parseInt(strNum);
otp_generated=num;
System.out.println("otp1 rand:"+otp_generated);
return num;
}
                   
             
                   
        @Override
       public void actionPerformed(ActionEvent e)
        {
            
            String un,a1,a2,b,c,d,p;
            un=t1.getText();
            String s=e.getActionCommand();
            //p=p1.getText();
            
 int temp=randomNumberGenerator();
         otp_generated=temp; 
         String temp1=Integer.toString(temp);
  //       System.out.println("temp:"+temp1);
//         temp1=String.parseString(temp);
            if(s.equals("Generate OTP"))
            {
        
                
                //System.out.println("gen:"+otp_generated);
                
           
                un=t1.getText();
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
				{i=0;
                                    b= rs.getString(1);
			if(un.equals(b))
                                {
                                    
                                    email= rs.getString(7);
//                                    generateAndSendEmail(email,otp_generated);
                                   new frame6(email,otp_generated);
                                   dispose();
                                   new frame7(un,otp_generated);
                                   
                             //      System.out.println("otppp"+otp_generated);
                                 
                                   rs.close();
                                   break;
                                }
                             else
	  {
        i++;
	  }
	}
                                if(i!=0)
                                    JOptionPane.showMessageDialog(null,"Invalid Username.","Message",JOptionPane.ERROR_MESSAGE);
  
                        rs.close();
                        }
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
            
            
            
            if(s.equals("Submit"))
            {
                System.out.println(otp_generated);
                int otp=Integer.parseInt(t2.getText());
                System.out.println("otp_text:"+otp);
                System.out.println("otp_gen:"+otp_generated);
                if(otp==otp_generated)
        {
            System.out.println("done");
                un=t1.getText();
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
			if(un.equals(b))
                                {
                                    
                 PreparedStatement pst = conn.prepareStatement("update BookMaster89 SET Password=? WHERE Username=?");
           pst.setString(1, p1.getText());
         pst.setString(2, un);
                            pst.executeUpdate();        
                               JOptionPane.showMessageDialog(null,"Password successfully updated.","Message",JOptionPane.INFORMATION_MESSAGE);
                                   
                                  rs.close();
                                   break;
                                }
                             
	}
                                if(i!=0)
                                    JOptionPane.showMessageDialog(null,"Invalid Username.","Message",JOptionPane.ERROR_MESSAGE);
  
                        rs.close();
                        }
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
            
            JOptionPane.showMessageDialog(null,"Invalid OTP entered.","Message",JOptionPane.ERROR_MESSAGE);
        } 
        }                 
            if(s.equals("Home"))
            {
                dispose();
                new frame1();
                
            }

        }
       
}
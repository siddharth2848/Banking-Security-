import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class frame2 extends JFrame implements ActionListener
{
  JButton b1,b2;
  JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
  JTextField t2,t3,t4,t5,t6,t7,t8,t9,t10;
  JComboBox jcb1,jcb2,jcb3;
  JPasswordField jp1,jp2;
  int i=0;
  String[] ques = { "Select a question","What was the name of your first car make?", "What was the name of your first childhood friend?", 
  "Which city native does your mother belong?", "What was your favourite food as child?"};
  
  String[] type={"Select Account Type","Savings Account","Current Account"};
  frame2()
  {
       setSize(790,700);
      setLocationRelativeTo(null);
	setTitle("Sign Up-AARS BANK");
        setLayout(null);
	setVisible(true);
	setSize(790,700);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setBackground(Color.WHITE);
	
	b1=new JButton("SAVE");
	add(b1);
	b1.setFont(new Font("junction regular",Font.BOLD,20));
	b1.setBounds(300,600,100,30);
        
	l1=new JLabel("Account Type");
	add(l1);
	l1.setFont(new Font("junction regular",Font.BOLD,15));
	l1.setBounds(45,30,100,30);
	
	
	l2=new JLabel("Account Number");
	l2.setFont(new Font("junction regular",Font.BOLD,15));
	l2.setBounds(45,80,150,30);
	add(l2);
	
	/*l3=new JLabel("Date of Birth");
	l3.setFont(new Font("junction regular",Font.BOLD,15));
	l3.setBounds(45,130,150,30);
	add(l3);*/
	
	l4=new JLabel("User Name");
	l4.setFont(new Font("junction regular",Font.BOLD,15));
	l4.setBounds(45,130,150,30);
	add(l4);
		
	l5=new JLabel("Password");
	l5.setBounds(45,180,150,30);
        l5.setFont(new Font("junction regular",Font.BOLD,15));
	add(l5);
	
	l6=new JLabel("Confirm Password");
        l6.setFont(new Font("junction regular",Font.BOLD,15));
	l6.setBounds(45,230,150,30);
	add(l6);
	
	l7=new JLabel("E-mail Id");
        l7.setFont(new Font("junction regular",Font.BOLD,15));
	l7.setBounds(45,280,150,30);
	add(l7);
	
	l8=new JLabel("Mobile No.");
        l8.setFont(new Font("junction regular",Font.BOLD,15));
	l8.setBounds(45,330,150,30);
	add(l8);
	
	l9=new JLabel("Security question 1");
        l9.setFont(new Font("junction regular",Font.BOLD,15));
	l9.setBounds(45,380,150,30);
	add(l9);
	
	l10=new JLabel("Answer");
        l10.setFont(new Font("junction regular",Font.BOLD,15));
	l10.setBounds(45,430,150,30);
	add(l10);
	
	l11=new JLabel("Security question 2");
        l11.setFont(new Font("junction regular",Font.BOLD,15));
	l11.setBounds(45,480,150,30);
	add(l11);
	
	l12=new JLabel("Answer");
        l12.setFont(new Font("junction regular",Font.BOLD,15));
	l12.setBounds(45,530,150,30);
	add(l12);
        
        jcb3 = new JComboBox(type);
	jcb3.setBounds(300,30,300,30);
	add(jcb3);
        l14=new JLabel("All fields are mandatory.");
        l14.setBounds(45,540,150,60);
        add(l14);
	
	t2=new JTextField();
	add(t2);
	t2.setBounds(300,80,300,30);
	
	/*t3=new JTextField();
	add(t3);
	t3.setBounds(300,130,300,30);
	
	l13=new JLabel("format:dd-mm-yyyy");
        l13.setBounds(300,140,300,50);
        add(l13);*/
        
	t4=new JTextField();
	add(t4);
	t4.setBounds(300,130,300,30);
	
	jp1=new JPasswordField();
        jp1.setTransferHandler(null);
        jp1.addKeyListener(new KeyWork());
	add(jp1);
	jp1.setBounds(300,180,300,30);
	
	jp2=new JPasswordField();       //password input
	jp2.setTransferHandler(null);  //copy-paste won't work(for security reasons)
        jp2.addKeyListener(new KeyWork());
        add(jp2);
	jp2.setBounds(300,230,300,30);
	
	t7=new JTextField();
	add(t7);
	t7.setBounds(300,280,300,30);
	
	t8=new JTextField();
	add(t8);
	t8.setBounds(300,330,300,30);
	
	jcb1 = new JComboBox(ques);                 //drop-down list
	jcb1.setBounds(300,380,300,30);
	add(jcb1);
	
	jcb2 = new JComboBox(ques);
	jcb2.setBounds(300,480,300,30);
	add(jcb2);
	
	t9=new JTextField();
	add(t9);
	t9.setBounds(300,430,300,30);
	
	t10=new JTextField();
	add(t10);
	t10.setBounds(300,530,300,30);
        
        b2=new JButton("Home");
        b2.setFont(new Font("junction regular",Font.BOLD,20));
        b2.setBounds(670,20,95,30);
        add(b2);
	
	b1.addActionListener(this);
        b2.addActionListener(this);
        
  }
  class EmailCheck 
  {
        String emailId;
  public void setEmailId(String emailId){
    this.emailId=emailId;
}
public String getEmailId(){
    return emailId;
}
public  boolean emailvalidate(String em2)
{
boolean stmt=true;
//String em2="siddharth2848@gmail.com";
    EmailCheck em = new EmailCheck();
    em.setEmailId(em2);
    String email = em.getEmailId();
    int length = email.length();
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;
    
    int count = 0;


    //Condition 1 
    if((length>3 && length<40)== true)
        flag1 = true;
    else 
        flag1 = false;

    //Condition 2
        int temp = email.length();
        if(email.contains("@")){
            flag2=true;
            int a=email.indexOf("@");
             for(int i=a;i<temp;i++){
        if(email.charAt(i)=='.'){
        flag3=true; 
        count=count+1;
        }
        }
             flag4 = count >= 1 && count <= 2;
        }
        else{
        flag2 =false;
        System.out.println("No @ symbol present");
        }
    if(flag1==true && flag2==true && flag3==true && flag4==true  )
    {
        System.out.println("Email ID is valid");
        return stmt;
		
    }
                else
    {
        JOptionPane.showMessageDialog(null,"Enter valid Email Id.","Message",JOptionPane.ERROR_MESSAGE);
        return !stmt;
    }
    }
}

  private class KeyWork extends KeyAdapter
    {
        public void keyPressed(KeyEvent k)
        {
            //if(/*k.getKeyCode() == KeyEvent.VK_V &&*/(KeyEvent.CTRL_MASK) != 0)
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
  
  public boolean validation()
  {
      EmailCheck obj=new EmailCheck();
      boolean stmt=true;
     String a,b,c,d,e,f,g,h,j,k,l,m;
     a=t2.getText();
     //b=t3.getText();
     c=t4.getText();
     d=jp1.getText();
     e=jp2.getText();
     f=t7.getText();
     g=t8.getText();
     h=t9.getText();
     j=t10.getText();
     k=(String)jcb1.getSelectedItem();
     l=(String)jcb2.getSelectedItem();
     m=(String)jcb3.getSelectedItem();
     
     if(a.equals("")&&c.equals("")&&d.equals("")&&e.equals("")&&f.equals("")&&g.equals("")&&h.equals("")&&j.equals(""))
      {
          JOptionPane.showMessageDialog(null,"Field's can't be left empty.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }
     
        if(a.equals(""))
      {
          JOptionPane.showMessageDialog(null,"Please enter Account Number.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }
    /* else   if(b.equals(""))
      {
         JOptionPane.showMessageDialog(null,"Please enter date of birth.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }*/
     if(c.equals(""))
      {
          JOptionPane.showMessageDialog(null,"Please enter username.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }
     if((c.length()<6))
       {
           JOptionPane.showMessageDialog(null,"UserName should be of length 6-14 characters","Message",JOptionPane.ERROR_MESSAGE);
           return !stmt;
       }
      if(d.equals(""))
      {
          JOptionPane.showMessageDialog(null,"Please enter password.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }
      if(e.equals(""))
      {
         JOptionPane.showMessageDialog(null,"Please enter password.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }
      if(f.equals(""))
      {
          JOptionPane.showMessageDialog(null,"Please enter E-mail Id","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }
      if(g.equals(""))
      {
         JOptionPane.showMessageDialog(null,"Please enter Mobile No.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }
      if(h.equals(""))
      {
          JOptionPane.showMessageDialog(null,"Please enter answer for question 1.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }
      if(j.equals(""))
      {
         JOptionPane.showMessageDialog(null,"Please enter answer for question 2.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
      }
    if(k.equals("Select question 1"))
        {
            JOptionPane.showMessageDialog(null,"Please select a question.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
        }
         if(l.equals("Select question 2"))
            {
            JOptionPane.showMessageDialog(null,"Please select a question.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
        }
         if(m.equals("Select Account Type"))
        {
             JOptionPane.showMessageDialog(null,"Please select Account Type.","Message",JOptionPane.ERROR_MESSAGE);
          return !stmt;
        }
         if(!d.equals(e))
      {JOptionPane.showMessageDialog(null,"Both Passwords are not same","Message",JOptionPane.ERROR_MESSAGE);
      return !stmt;
      }
        if(!f.equals(""))
       {
             stmt=obj.emailvalidate(f);
             return stmt;
       }
        if(g.length()!=10)
       {
           JOptionPane.showMessageDialog(null,"Mobile No. should be of 10 digits. ","Message",JOptionPane.ERROR_MESSAGE);
           return !stmt;
       }
       
       /*else if(c.length()!>6&&c.length()!<14)
       {
           JOptionPane.showMessageDialog(null,"Invalid Date format. ","Message",JOptionPane.ERROR_MESSAGE);
           return !stmt;
       }*/
       if((c.length()<6))
       {
           JOptionPane.showMessageDialog(null,"UserName should be of length 6-14 characters","Message",JOptionPane.ERROR_MESSAGE);
           return !stmt;
       }
        if(!(d.length()>=8&&d.length()<=16))
       {
           JOptionPane.showMessageDialog(null,"Password should be of length 8-16 characters.","Message",JOptionPane.ERROR_MESSAGE);
           return !stmt;
       }
        if(!(e.length()>=8&&e.length()<=16))
       {
           JOptionPane.showMessageDialog(null,"Password should be of length 8-16 characters.","Message",JOptionPane.ERROR_MESSAGE);
           return !stmt;
       }
       
       
      else
          return stmt;
 }
  
  @Override
  public void actionPerformed(ActionEvent ae)
  {
    String s=ae.getActionCommand();
    if(s.equals("Home"))
        {
            //setVisible(false);
            
            new frame1();
            dispose();
        }
        
        if(s.equals("SAVE"))
    {
        boolean cnd;
       cnd=validation();
        if(cnd)
        {
        i=0;
		String a=t4.getText();                      //save text input in field to database
		String b=jp1.getText();
		String c=(String)jcb1.getSelectedItem();
		String d=t9.getText();
		String e=(String)jcb2.getSelectedItem();
		String f=t10.getText();
                String g=t7.getText();
                String h=(String)jcb3.getSelectedItem();
               String j=(t2.getText());
               String k=t8.getText();
                //String l=t3.getText();

   
	try
{
Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			conn = DriverManager.getConnection("Jdbc:Odbc:emp");

			if (conn != null)
			{
				stmt=conn.createStatement();
	String query = "SELECT * FROM BookMaster89";
				ResultSet  rs = stmt.executeQuery(query);
				while (rs.next())
				{
                                    i=0;
                                    String	b1= rs.getString("Username");
                                    //String	cc= rs.getString("Password");
				if(a.equals(b1))
					{
                                            i++;
                                            break;
                                        }
                                
                                }
        if(i==0)
            {
                stmt.executeUpdate("INSERT INTO BookMaster89(Username,Password,SC1,A1,SC2,A2,Email,AccType,AccNo,Mob) VALUES('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+j+"','"+k+"')");
                JOptionPane.showMessageDialog(null,"Successfully signed up.","Message",JOptionPane.INFORMATION_MESSAGE);
               dispose();
               new frame1();
            }
                  
         else
         {
           
          JOptionPane.showMessageDialog(null,"Username already exists.","Message",JOptionPane.ERROR_MESSAGE);
         
         
                        }
				
			}
		}
		catch (Exception ce)
		{
			System.err.println ("Cannot connect to database server"+ce);
		}
conn.close();
}
catch(SQLException de)
{
}     
}      	
}
}
}
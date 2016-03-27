import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

class frame6 
{
 
static Properties mailServerProperties;
static Session getMailSession;
static MimeMessage generateMailMessage;
 
frame6(String mailid,int otp) throws AddressException, MessagingException 
{
generateAndSendEmail(mailid,otp);
//System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
}
 
/*public static int randomNumberGenerator()
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
return num;
}*/


public static void generateAndSendEmail(String mailid,int otp) throws AddressException, MessagingException {
 
 //String mailid="dude.siddharthm@yahoo.in";
//Step1
   // System.out.println(+otp+":on mail");
//System.out.println("\n 1st ===> setup Mail Server Properties..");
mailServerProperties = System.getProperties();
mailServerProperties.put("mail.smtp.port", "587");
mailServerProperties.put("mail.smtp.auth", "true");
mailServerProperties.put("mail.smtp.starttls.enable", "true");
//System.out.println("Mail Server Properties have been setup successfully..");
 
//Step2
//System.out.println("\n\n 2nd ===> get Mail Session..");
getMailSession = Session.getDefaultInstance(mailServerProperties, null);
generateMailMessage = new MimeMessage(getMailSession);
generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailid));
//generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("aggarwalraghavseven@gmail.com"));
//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("amolcool65@gmail.com"));
generateMailMessage.setSubject("OTP for Change of Password");
String emailBody = "Dear User,"+"<br>Here is your four digit OTP for change of password is " +otp+ "<br><br> Regards, <br>AARS BANK";
generateMailMessage.setContent(emailBody, "text/html");
//System.out.println("Mail Session has been created successfully..");
 
//Step3
//System.out.println("\n\n 3rd ===> Get Session and Send mail");
Transport transport = getMailSession.getTransport("smtp");
// Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
transport.connect("smtp.gmail.com", "siddharth131995@gmail.com", "momdad9915598728");
transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
transport.close();
//new frame4(otp);
JOptionPane.showMessageDialog(null,"OTP has been sent on your registered mailid.","Message",JOptionPane.INFORMATION_MESSAGE);
  
}
}
package company.main;

/*
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Date;
*/
public class Mail{
	public static void main(String[] args) throws Exception{
		/*
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		//MimeMessage message = new MimeMessage(session, new FileInputStream("email.eml"));
		message.setFrom(new InternetAddress("meichao820@qq.com", "meichao820" ,"UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("meichao820", "meichao820	", "UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("meichao820", "meichao820	", "UTF-8"));
		message.setSubject("subject");
		message.setContent("mail body", "text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();
		OutputStream out = new FileOutputStream("email.eml");
		message.writeTo(out);
		out.flush();
		out.close();
		Properties props = new Properties();
		*/
	}
}
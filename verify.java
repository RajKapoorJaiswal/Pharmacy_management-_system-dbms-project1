import java.awt.EventQueue;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class verify extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailid;
	private JTextField textField_1;
	private String n3;
	private JLabel lblNewLabel;
	private JLabel lblOtp;
	private JButton back;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verify frame = new verify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public verify() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		emailid = new JTextField();
		emailid.setBounds(153, 83, 289, 34);
		contentPane.add(emailid);
		emailid.setColumns(10);
		
		JButton btnNewButton = new JButton("Send otp");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				String fr = emailid.getText();
				 String to = fr; // to address. It can be any like gmail, hotmail etc.
				  final String from = "rajkapoorjaiswal110@gmail.com"; // from address. As this is using Gmail SMTP.
				  final String password = "ypyu rqad rdld hvpe"; // password for from mail address. 
				  Properties prop = new Properties();

				  prop.put("mail.smtp.host", "smtp.gmail.com");
				  prop.put("mail.smtp.port", "465");
				  prop.put("mail.smtp.auth", "true");
				
				  prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
				  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			      
			      
			      Session session = Session.getDefaultInstance(prop,  
			       new javax.mail.Authenticator() {  
			       protected PasswordAuthentication getPasswordAuthentication() {  
			       return new PasswordAuthentication(from,password);  
			       }  
			      });  
			         
			      //2) compose message     
			      try {
						 
					   Message message = new MimeMessage(session);
					   message.setFrom(new InternetAddress(from));
					   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
					   message.setSubject("Verification Mail");
					   int n;
					   Random ran = new Random();
					   n = ran.nextInt();
					   n=Math.abs(n);
					   System.out.println(n);
					   n3 = String.valueOf(n);
					   String msg = "OTP :"+n3 ;
					    
					   MimeBodyPart mimeBodyPart = new MimeBodyPart();
					   mimeBodyPart.setContent(msg, "text/html");
					     
					   Multipart multipart = new MimeMultipart();
					   multipart.addBodyPart(mimeBodyPart);
					    
					 
					   message.setContent(multipart);
					 
					   Transport.send(message);
					 
					   System.out.println("Mail successfully sent..");
					   
					  } catch (MessagingException er) {
					   er.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(463, 70, 125, 35);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 147, 253, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("verify");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().equals(n3)) {
					System.out.println("hello");
					 new Forgetpass().setVisible(true);
	                    SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
			}
		});
		btnNewButton_1.setBounds(284, 192, 111, 34);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(60, 86, 67, 23);
		contentPane.add(lblNewLabel);
		
		lblOtp = new JLabel("OTP");
		lblOtp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOtp.setBounds(74, 158, 67, 23);
		contentPane.add(lblOtp);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    login newframe = new login();
                    newframe.setVisible(true);
                    SwingUtilities.windowForComponent(back).dispose();
  
		}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(74, 279, 111, 34);
		contentPane.add(back);
		
		JLabel lblForgetPassword = new JLabel("Forget password");
		lblForgetPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblForgetPassword.setBounds(230, 25, 138, 23);
		contentPane.add(lblForgetPassword);
	}
}

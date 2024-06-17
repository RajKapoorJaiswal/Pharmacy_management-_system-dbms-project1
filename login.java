import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    static JTextField user;
    private JPasswordField pass;
    private JTextField textField;
	private String captcha;
	private JLabel lblNewLabel_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login frame = new login();
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
    public login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 573, 564);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel_2_1 = new JLabel("Captcha");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1.setBounds(62, 311, 89, 36);
        contentPane.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2 = new JLabel("Enter Captcha");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2.setBounds(33, 250, 117, 36);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel = new JLabel("Welcome Pharmacist");
        lblNewLabel.setBounds(79, 40, 397, 83);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("UserName");
        lblNewLabel_1.setBounds(33, 133, 117, 38);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Password");
        lblNewLabel_1_1.setBounds(33, 202, 117, 38);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_1);

        user = new JTextField();
        user.setBounds(175, 133, 226, 42);
        contentPane.add(user);
        user.setColumns(10);

        pass = new JPasswordField();
        pass.setBounds(175, 202, 226, 38);
        contentPane.add(pass);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBounds(33, 375, 117, 38);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String us = user.getText();
                    String ps = new String(pass.getPassword());
                    if("".equals(us) || "".equals(ps) ) {
                        JOptionPane.showMessageDialog(btnNewButton, "Enter Username or Password", "Login Failure", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/login","root","raj@2004");
                        Statement st = con.createStatement();
                        String sql = "SELECT username, password FROM access";
                        ResultSet rs = st.executeQuery(sql);
                        boolean loginSuccess = false;
                        while(rs.next()){
                            String username = rs.getString("username");
                            String password = rs.getString("password");
                            if(us.equals(username) && ps.equals(password) && captcha.equals(textField.getText())){
                                new Dashboard().setVisible(true);
                                SwingUtilities.windowForComponent(btnNewButton).dispose();
                                loginSuccess = true;
                                break;
                            }
                        }
                        rs.close();
                        st.close();
                        con.close();
                        if(!loginSuccess) {
                            user.setText("Invalid");
                            pass.setText("Invalid");
                            JOptionPane.showMessageDialog(btnNewButton, "Login Failed", "Login", JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(btnNewButton, "Login Success", "Login", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch(Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton, "Error while establishing connection", "Connection Error", JOptionPane.ERROR_MESSAGE);
                    o.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("ForgetPass");
        btnNewButton_1.setBounds(184, 375, 184, 38);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new verify().setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton).dispose();
                } catch(Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton, "Error while establishing connection", "Connection Error", JOptionPane.ERROR_MESSAGE);
                    o.printStackTrace();
                }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnNewButton_1);

        JButton CreateAccount = new JButton("Create new account");
        CreateAccount.setBounds(333, 434, 216, 38);
        CreateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new signup().setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton).dispose();
                } catch(Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton, "Error while establishing connection", "Connection Error", JOptionPane.ERROR_MESSAGE);
                    o.printStackTrace();
                }
            }
        });
        CreateAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(CreateAccount);

        JCheckBox txtpa = new JCheckBox("Show password");
        txtpa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtpa.isSelected()) {
                    pass.setEchoChar((char) 0);
                } else {
                    pass.setEchoChar('•');
                }
            }
        });
        txtpa.setFont(new Font("Tahoma", Font.BOLD, 13));
        txtpa.setBounds(413, 205, 136, 38);
        contentPane.add(txtpa);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(175, 250, 226, 42);
        contentPane.add(textField);
        
       lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        captcha = generateCaptcha();
        lblNewLabel_3.setText(captcha);
        lblNewLabel_3.setBounds(175, 311, 226, 36);
        contentPane.add(lblNewLabel_3);
        
        JButton btnNewButton_2 = new JButton("Refresh");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		captcha = generateCaptcha();
        		lblNewLabel_3.setText(captcha);
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setBounds(410, 310, 110, 37);
        contentPane.add(btnNewButton_2);
    }

	private static String generateCaptcha() {
		 Random rand = new Random();
	        int length = 7 + (Math.abs(rand.nextInt()) % 3);
	        StringBuilder captcha = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            int base = Math.abs(rand.nextInt()) % 62;
	            char charN;
	            if (base < 26) {
	                charN = (char) (65 + base);
	            } else if (base < 52) {
	                charN = (char) (97 + (base - 26));
	            } else {
	                charN = (char) (48 + (base - 52));
	            }
	            captcha.append(charN);
	        }
	        return captcha.toString();

		// TODO Auto-generated method stub
		//return null;
	}
}

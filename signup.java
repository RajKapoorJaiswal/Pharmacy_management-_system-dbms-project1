import java.awt.Component;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;

public class signup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField user;
    private JPasswordField pass;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signup frame = new signup();
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
    public signup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 679, 591);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1_2 = new JLabel("Password:");
        lblNewLabel_1_2.setBounds(59, 345, 110, 31);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_5 = new JLabel("Username:");
        lblNewLabel_1_5.setBounds(59, 253, 110, 31);
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_5);

        user = new JTextField();
        user.setBounds(187, 254, 301, 37);
        user.setColumns(10);
        contentPane.add(user);

        JButton Back = new JButton("Back");
        Back.setBounds(81, 468, 115, 31);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login newframe = new login();
                newframe.setVisible(true);
                SwingUtilities.windowForComponent(Back).dispose();
            }
        });
        Back.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(Back);

        JButton Signup = new JButton("Signup");
        Signup.setBounds(404, 468, 115, 31);
        Signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String username = user.getText();
                String password = new String(pass.getPassword());

                try {
        			int c=0;
        			String nu = user.getText();
        			String np = pass.getText();	
        			
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3307/login","root","raj@2004");
        			Statement st1 = con1.createStatement();
        			
        			String sql1 =  "Select * from access";
        			ResultSet res1 = st1.executeQuery(sql1);
        			System.out.println("1");
        			
        			System.out.println("2");
        			String sql2 = "SELECT COUNT(*) AS count FROM access";
        			System.out.println("3");
        			PreparedStatement ps2 = con1.prepareStatement(sql2);
        			System.out.println("4");
        			ResultSet res2 = ps2.executeQuery();
        			System.out.println("5");
        			while(res2.next())
        			{ c = res2.getInt(1);
        			 System.out.print(c);}
        			c+=1;
        			
        					String sql3 = "insert into access values("+c+",'"+nu+"','"+np+"')";
        					PreparedStatement pts = con1.prepareStatement(sql3);
        					System.out.print(np);
        				    
        					System.out.println("2");
        					pts.executeUpdate(sql3);
        					System.out.print("success");
        					JOptionPane.showMessageDialog(null, " data created", "created", -1);
        					
        						login newframe = new login();
        						newframe.setVisible(true);
        						SwingUtilities.windowForComponent(Signup).dispose();
        		
        			}catch(Exception os)
        			{
        				System.out.print(os);
        				JOptionPane.showMessageDialog(Signup, this, "Error while establishing connection failed", 0);
        			}
                           
            }});
        Signup.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(Signup);
        
        pass = new JPasswordField();
        pass.setBounds(187, 349, 301, 31);
        contentPane.add(pass);
        
        JLabel lblNewLabel = new JLabel("Create New Account ");
        lblNewLabel.setBounds(187, 129, 237, 37);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel);
        
        JLabel lblPharmacyManagementSysytem = new JLabel("Pharmacy Management sysytem");
        lblPharmacyManagementSysytem.setBounds(95, 41, 465, 37);
        lblPharmacyManagementSysytem.setBackground(new Color(240, 240, 240));
        lblPharmacyManagementSysytem.setFont(new Font("Tahoma", Font.BOLD, 25));
        contentPane.add(lblPharmacyManagementSysytem);
        
        JCheckBox txtpa = new JCheckBox("show password");
        txtpa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtpa.isSelected()) {
                    pass.setEchoChar((char) 0);
                } else {
                    pass.setEchoChar('•');
                }
            }
        });
        txtpa.setFont(new Font("Tahoma", Font.BOLD, 10));
        txtpa.setBounds(507, 354, 125, 22);
        contentPane.add(txtpa);
    }	
}

    

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Dashboard");
		lblNewLabel.setBounds(155, 10, 306, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 63, 737, 28);
		contentPane.add(separator);
		
		JButton Addmedicine = new JButton("Add Medicine");
		Addmedicine.setBounds(32, 137, 241, 48);
		Addmedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Addmedicine newframe = new Addmedicine();
				    newframe.setVisible(true);
					SwingUtilities.windowForComponent(Addmedicine).dispose();
			}
		});
		Addmedicine.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(Addmedicine);
		
		JButton ViewMedicine = new JButton("View Medicine");
		ViewMedicine.setBounds(32, 244, 241, 48);
		ViewMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 viewmedicine frame = new viewmedicine();
	                frame.setVisible(true);
	                dispose();
			}
		});
		ViewMedicine.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(ViewMedicine);
		
		JButton Logout = new JButton("Logout");
		Logout.setBounds(201, 516, 241, 48);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					login newframe = new login();
				    newframe.setVisible(true);
					SwingUtilities.windowForComponent(Logout).dispose();
			}
		});
		Logout.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(Logout);
		
		JButton btnSellMedicine = new JButton("Sell Medicine");
		btnSellMedicine.setBounds(357, 137, 235, 48);
		btnSellMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 sellmedicine frame = new sellmedicine();
	                frame.setVisible(true);
	                dispose();
			}
		});
		btnSellMedicine.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnSellMedicine);
		
		JButton btnViewMedicine_1 = new JButton("View Bill");
		btnViewMedicine_1.setBounds(357, 353, 241, 48);
		btnViewMedicine_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewbill().setVisible(true);
				 viewbill frame = new viewbill();
	                frame.setVisible(true);
	                dispose();
			}
		});
		btnViewMedicine_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnViewMedicine_1);
		
		JButton btnUpdateMedicine = new JButton("Update Medicine");
		btnUpdateMedicine.setBounds(32, 353, 261, 48);
		btnUpdateMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 updatemedicine frame = new updatemedicine();
	                frame.setVisible(true);
	                dispose();
			}
		});
		btnUpdateMedicine.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnUpdateMedicine);
		
		JButton btnViewMedicine_1_1 = new JButton("Add bill");
		btnViewMedicine_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bill info = new bill();
				bill.main(null);
				dispose();
			}
		});
		btnViewMedicine_1_1.setBounds(351, 256, 241, 48);
		btnViewMedicine_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(btnViewMedicine_1_1);
	}

}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VIEWUSER extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JButton Back;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIEWUSER frame = new VIEWUSER();
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
	public VIEWUSER() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View User");
		lblNewLabel.setBounds(296, 23, 194, 39);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 59, 839, 15);
		contentPane.add(separator);
		
		table = new JTable();
		table.setBounds(333, 169, 1, 1);
		table.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(table);
		
		scrollPane = 
				new JScrollPane();
		scrollPane.setBounds(10, 72, 839, 287);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Date of birth(dob)", "Mobile Number", "Email", "Address"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(86);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(86);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(103);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(86);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(138);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(91);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		Back = new JButton("Back");
		Back.setBounds(10, 405, 109, 31);
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Dashboard newframe = new Dashboard();
				    newframe.setVisible(true);
					SwingUtilities.windowForComponent(Back).dispose();
			}
		});
		Back.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(Back);
		
		JButton show = new JButton("show");
		show.setBounds(296, 405, 110, 31);
		show.setFont(new Font("Tahoma", Font.BOLD, 20));
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine","root","raj@2004");
				Statement si=(Statement) con.createStatement();
				String sql="select * from add_user";
				
				PreparedStatement pts=con.prepareStatement(sql);
				ResultSet rs= pts.executeQuery();
				    DefaultTableModel dt=(DefaultTableModel)table_1.getModel();
				dt.setRowCount(0);
				while(rs.next()) {
				
				Object o[]= {rs.getString("id"),rs.getString("Name"),rs.getString("DOB"),rs.getString("MobileNumber"),rs.getString("Email"),rs.getString("Address")};
				dt.addRow(o);
				}
		}
			catch(Exception ec) {
				JOptionPane.showMessageDialog(null,"it has not been registered");
				ec.printStackTrace();
			}
			}
		});
		contentPane.add(show);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;

public class updatemedicine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_6_1;
	private JTextField search;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatemedicine frame = new updatemedicine();
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
	public updatemedicine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 795);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Medicine");
		lblNewLabel.setBounds(220, -27, 319, 85);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(305, 185, 0, 0);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(28, 30, 990, 28);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Medicine ID");
		lblNewLabel_1.setBounds(10, 48, 150, 28);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(139, 47, 201, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setBounds(10, 118, 150, 28);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Company Name");
		lblNewLabel_1_2.setBounds(10, 185, 214, 28);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(101, 117, 276, 40);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(20, 223, 285, 40);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(28, 322, 285, 40);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setBounds(481, 539, 129, 28);
		btnUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String i = textField.getText();
				String mn = textField_1.getText();
				String cn = textField_2.getText();
				String mfg = textField_3.getText();
				String exp = textField_4.getText();
				String q = textField_5.getText();
				String ppu = textField_6_1.getText();
		
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine","root","raj@2004");
				   
					PreparedStatement pst = con1.prepareStatement("update medicine2 set Medicine_Name=?, Company_Name=?, Mfg_Date=?, Exp_Date=?, Quantity=?, Price_per_Unit=? where Medicine_ID=?");
				    pst.setString(1, mn);
				    pst.setString(2, cn);
				    pst.setString(3, mfg);
				    pst.setString(4, exp);
				    pst.setString(5, q);
				    pst.setString(6, ppu);
				    pst.setString(7, i);
				    
				    int rowsAffected = pst.executeUpdate();
				    if (rowsAffected > 0) {
				        JOptionPane.showMessageDialog(null, "Successfully updated");
				        setVisible(false);
				        new Dashboard().setVisible(true);
				    } else {
				        JOptionPane.showMessageDialog(null, "Failed to update");
				    }
				    
				    pst.close();
				    con1.close();
				} catch (Exception e1) {
				    e1.printStackTrace();
				    // Handle any SQL errors
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnUpdate);
		
		JButton Back = new JButton("Back");
		Back.setBounds(380, 626, 129, 28);
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard newframe = new AdminDashboard();
				newframe.setVisible(true);
				SwingUtilities.windowForComponent(Back).dispose();
			}
		});
		Back.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(Back);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(670, 539, 129, 28);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = textField.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine","root","raj@2004");
					String sql = "delete from medicine2 WHERE Medicine_ID=?";
					PreparedStatement pts = con.prepareStatement(sql);
					pts.setString(1, code);
					
					pts.execute();
					JOptionPane.showMessageDialog(null, "It has been deleted");
				} catch (Exception ec) {
					JOptionPane.showMessageDialog(null, "It has not been deleted");
					ec.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(366, 190, 639, 307);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Medicine_ID", "Medicine_Name", "Company_Name", "Mfg-Date", "Exp_Date", "Quantity", "Price_per_Unit"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(79);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(82);
		table.getColumnModel().getColumn(4).setPreferredWidth(86);
		table.getColumnModel().getColumn(6).setPreferredWidth(79);
		
		JButton btnNewButton_1_1 = new JButton("show");
		btnNewButton_1_1.setBounds(841, 534, 135, 39);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine","root","raj@2004");
					Statement st = con.createStatement();
					String sql = "select * from medicine2";
					
					PreparedStatement pts = con.prepareStatement(sql);
					ResultSet rs = pts.executeQuery();
					DefaultTableModel dt = (DefaultTableModel) table.getModel();
					dt.setRowCount(0);
					while (rs.next()) {
						Object[] o = {
							rs.getString("Medicine_ID"),
							rs.getString("Medicine_Name"),
							rs.getString("Company_Name"),
							rs.getString("Mfg_Date"),
							rs.getString("Exp_Date"),
							rs.getString("Quantity"),
							rs.getString("Price_per_Unit")
						};
						dt.addRow(o);
					}
					con.close();
				} catch (Exception ec) {
					JOptionPane.showMessageDialog(null, "Error displaying records");
					ec.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnNewButton_1_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(28, 402, 285, 40);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Quantity");
		lblNewLabel_1_3_1.setBounds(28, 467, 150, 28);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel mfg_1_1 = new JLabel("mfg_date");
		mfg_1_1.setBounds(28, 296, 150, 28);
		mfg_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(mfg_1_1);
		
		JLabel exp_date_1_1 = new JLabel("exp_date");
		exp_date_1_1.setBounds(28, 372, 150, 28);
		exp_date_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(exp_date_1_1);
		
		textField_6_1 = new JTextField();
		textField_6_1.setBounds(20, 596, 303, 40);
		textField_6_1.setColumns(10);
		contentPane.add(textField_6_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Price Per Unit");
		lblNewLabel_1_4_1_1.setBounds(28, 558, 150, 28);
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_4_1_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(530, 118, 129, 28);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");
			            String query = "SELECT * FROM medicine2 WHERE Medicine_Name LIKE ?";
			            PreparedStatement pts = con.prepareStatement(query);
			            pts.setString(1, search.getText() + "%");
			            ResultSet rs = pts.executeQuery();
			            DefaultTableModel dt = (DefaultTableModel) table.getModel();
			            dt.setRowCount(0);
			            while (rs.next()) {
			                Object[] row = {
			                    rs.getString("Medicine_ID"),
			                    rs.getString("Medicine_Name"),
			                    rs.getString("Company_Name"),
			                    rs.getString("Mfg_Date"),
			                    rs.getString("Exp_Date"),
			                    rs.getString("Quantity"),
			                    rs.getString("Price_per_Unit")
			                };
			                dt.addRow(row);
			            }
			            con.close();
			        } catch (Exception ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
			        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		search = new JTextField();
		search.setBounds(519, 56, 214, 40);
		contentPane.add(search);
		search.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(29, 505, 276, 40);
		contentPane.add(textField_5);
	}
}

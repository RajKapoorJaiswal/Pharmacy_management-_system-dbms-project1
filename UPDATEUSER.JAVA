import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JComboBox;

public class updateuser extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Name;
    private JTextField Em;
    private JTextField MN;
    private JTextField id;
    private JTable table;

    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    updateuser frame = new updateuser();
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
    public updateuser() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1117, 740);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("UPDATE");
        lblNewLabel.setBounds(320, 10, 135, 53);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 55, 989, 20);
        contentPane.add(separator);

        JLabel lblNewLabel_1_1 = new JLabel("Name");
        lblNewLabel_1_1.setBounds(20, 262, 111, 27);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("DOB(Date of Birth)");
        lblNewLabel_1_2.setBounds(20, 337, 146, 27);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Email");
        lblNewLabel_1_3.setBounds(320, 186, 111, 27);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblNewLabel_1_3);

        Name = new JTextField();
        Name.setBounds(30, 288, 210, 39);
        Name.setColumns(10);
        contentPane.add(Name);

        // Combo boxes for Date of Birth
        dayComboBox = new JComboBox<>();
        dayComboBox.setBounds(30, 374, 60, 39);
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.format("%02d", i));
        }
        contentPane.add(dayComboBox);

        monthComboBox = new JComboBox<>();
        monthComboBox.setBounds(100, 374, 60, 39);
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(String.format("%02d", i));
        }
        contentPane.add(monthComboBox);

        yearComboBox = new JComboBox<>();
        yearComboBox.setBounds(170, 374, 70, 39);
        for (int i = 1900; i <= 2024; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }
        contentPane.add(yearComboBox);

        Em = new JTextField();
        Em.setBounds(320, 213, 222, 39);
        Em.setColumns(10);
        contentPane.add(Em);

        JLabel lblNewLabel_1_3_1 = new JLabel("Mobile Number");
        lblNewLabel_1_3_1.setBounds(20, 443, 146, 27);
        lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblNewLabel_1_3_1);

        MN = new JTextField();
        MN.setBounds(30, 480, 210, 39);
        MN.setColumns(10);
        contentPane.add(MN);

        JLabel lblNewLabel_1_3_2 = new JLabel("Address");
        lblNewLabel_1_3_2.setBounds(320, 292, 111, 27);
        lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblNewLabel_1_3_2);

        JButton btnNewButton_1 = new JButton("Update");
        btnNewButton_1.setBounds(272, 603, 135, 39);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String i = id.getText();
                String n = Name.getText();
                String d = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + dayComboBox.getSelectedItem();
                String m = MN.getText();
                String em = Em.getText();
                String a = new String(textField_1.getText());

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");

                    PreparedStatement pst = con1.prepareStatement("update add_user set Name=?, DOB=?, MobileNumber=?, Email=?, Address=? where id=?");

                    pst.setString(1, n);
                    pst.setString(2, d);
                    pst.setString(3, m);
                    pst.setString(4, em);
                    pst.setString(5, a);
                    pst.setString(6, i);

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
                }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_1_4 = new JLabel("User Role");
        lblNewLabel_1_4.setBounds(20, 113, 146, 39);
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_4);

        JButton Back = new JButton("Back");
        Back.setBounds(55, 603, 135, 39);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dashboard newframe = new Dashboard();
                newframe.setVisible(true);
                SwingUtilities.windowForComponent(Back).dispose();
            }
        });
        Back.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(Back);

        JButton btnNewButton_1_1 = new JButton("Delete");
        btnNewButton_1_1.setBounds(519, 603, 135, 39);
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");
                    Statement st = conn.createStatement();
                    String i = id.getText();
                    String sql = "DELETE FROM add_user WHERE id='" + i + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Deleted from users", "Delete Success", 3);
                } catch (Exception s) {
                    JOptionPane.showMessageDialog(null, s, "Delete Failed", 3);
                }
            }
        });
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnNewButton_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("id");
        lblNewLabel_1_1_1.setBounds(20, 186, 111, 27);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblNewLabel_1_1_1);

        id = new JTextField();
        id.setBounds(30, 213, 210, 39);
        id.setColumns(10);
        contentPane.add(id);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(597, 194, 500, 337);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnShow = new JButton("Show");
        btnShow.setBounds(740, 603, 135, 39);
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    table.setModel(new DefaultTableModel());

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");
                    Statement st = conn.createStatement();
                    String sql = "Select * from add_user";
                    ResultSet rs = st.executeQuery(sql);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    int cols = rsmd.getColumnCount();
                    String[] colName = new String[cols];

                    for (int i = 0; i < cols; i++) {
                        colName[i] = rsmd.getColumnName(i + 1).toUpperCase();
                    }
                    model.setColumnIdentifiers(colName);

                    String n, f, l, p, g, b;
                    while (rs.next()) {
                        n = rs.getString(1);
                        f = rs.getString(2);
                        l = rs.getString(3);
                        p = rs.getString(4);
                        g = rs.getString(5);
                        b = rs.getString(6);
                        String[] rows = {n, f, l, p, g, b};
                        model.addRow(rows);
                    }
                    st.close();
                    conn.close();

                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, E, "Refresh Failed", 3);
                }
            }
        });
        btnShow.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnShow);

        JButton btnNewButton_2 = new JButton("Search");
        btnNewButton_2.setBounds(939, 616, 130, 40);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    table.setModel(new DefaultTableModel());

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");
                    Statement st = conn.createStatement();
                    String v = id.getText();
                    String sql = "Select * from add_user where id='" + v + "'";
                    ResultSet rs = st.executeQuery(sql);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    int cols = rsmd.getColumnCount();
                    String[] colName = new String[cols];

                    for (int i = 0; i < cols; i++) {
                        colName[i] = rsmd.getColumnName(i + 1).toUpperCase();
                    }
                    model.setColumnIdentifiers(colName);

                    String n, f, l, p, g, b;
                    while (rs.next()) {
                        n = rs.getString(1);
                        f = rs.getString(2);
                        l = rs.getString(3);
                        p = rs.getString(4);
                        g = rs.getString(5);
                        b = rs.getString(6);
                        String[] rows = {n, f, l, p, g, b};
                        model.addRow(rows);
                    }
                    st.close();
                    conn.close();

                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null, E, "Search Failed", 3);
                }
            }
        });

        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(btnNewButton_2);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(320, 343, 222, 39);
        contentPane.add(textField_1);
        
        JLabel lblUser = new JLabel("USER");
        lblUser.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblUser.setBounds(475, 10, 135, 53);
        contentPane.add(lblUser);
    }
}

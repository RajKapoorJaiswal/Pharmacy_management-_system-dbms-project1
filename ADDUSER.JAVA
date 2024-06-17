import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ADDUSER extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextField no;
    private JTextField address;
    private JTextField id;
    private JComboBox<Integer> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<Integer> yearComboBox;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ADDUSER frame = new ADDUSER();
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
    public ADDUSER() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 632, 667);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Add User");
        lblNewLabel.setBounds(204, 27, 159, 31);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblNewLabel);
        
        JLabel dob3 = new JLabel("DOB(Date of Birth)");
        dob3.setBounds(10, 307, 159, 34);
        dob3.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(dob3);

        // Day Combo Box
        Integer[] days = new Integer[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = i;
        }
        dayComboBox = new JComboBox<>(days);
        dayComboBox.setBounds(10, 340, 60, 43);
        contentPane.add(dayComboBox);

        // Month Combo Box
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(80, 340, 100, 43);
        contentPane.add(monthComboBox);

        // Year Combo Box
        Integer[] years = new Integer[100];
        for (int i = 1950; i <= 2025; i++) {
            years[i - 1950] = i;
        }
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(190, 340, 80, 43);
        contentPane.add(yearComboBox);

        // Other components...

        JButton btnNewButton = new JButton("Save");
        btnNewButton.setBounds(327, 574, 103, 31);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");
                    
                    // Concatenate selected day, month, and year to form the date of birth
                    String dobValue = dayComboBox.getSelectedItem() + " " + monthComboBox.getSelectedItem() + " " + yearComboBox.getSelectedItem();
                    
                    String sql = "INSERT INTO add_user VALUES (?, ?, ?, ?, ?,?)";
                    PreparedStatement pts = con.prepareStatement(sql);
                    pts.setString(1, id.getText());
                    pts.setString(2, name.getText());
                    pts.setString(3, dobValue);
                    pts.setString(4, no.getText());
                    pts.setString(5, textField.getText());
                    pts.setString(6, address.getText());
                    pts.executeUpdate();
                    JOptionPane.showMessageDialog(null, "user id has been registered");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: user id has not been registered");
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnNewButton);

        JButton Back = new JButton("Back");
        Back.setBounds(71, 574, 103, 31);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    Dashboard newframe = new Dashboard();
                    newframe.setVisible(true);
                    SwingUtilities.windowForComponent(Back).dispose();
            }
        });
        Back.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(Back);

        // Other components...
        
        JLabel name1 = new JLabel("Name");
        name1.setBounds(10, 189, 128, 34);
        name1.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(name1);
        
        name = new JTextField();
        name.setBounds(10, 233, 226, 43);
        name.setColumns(10);
        contentPane.add(name);
        
        JLabel no4 = new JLabel("Mobile Number");
        no4.setBounds(10, 441, 128, 34);
        no4.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(no4);

        no = new JTextField();
        no.setBounds(10, 472, 226, 43);
        no.setColumns(10);
        contentPane.add(no);

        JLabel email5 = new JLabel("Email");
        email5.setBounds(387, 92, 128, 34);
        email5.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(email5);

        JLabel ads = new JLabel("Address");
        ads.setBounds(387, 201, 128, 34);
        ads.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(ads);

        address = new JTextField();
        address.setBounds(382, 245, 226, 43);
        address.setColumns(10);
        contentPane.add(address);

        JButton btnNewButton1 = new JButton("Save");
        btnNewButton1.setBounds(327, 574, 103, 31);
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");

                    // Concatenate selected day, month, and year to form the date of birth
                    String dobValue = dayComboBox.getSelectedItem() + " " + monthComboBox.getSelectedItem() + " " + yearComboBox.getSelectedItem();

                    String sql = "INSERT INTO add_user VALUES (?, ?, ?, ?, ?,?)";
                    PreparedStatement pts = con.prepareStatement(sql);
                    pts.setString(1, id.getText());
                    pts.setString(2, name.getText());
                    pts.setString(3, dobValue);
                    pts.setString(4, no.getText());
                    pts.setString(5, textField.getText());
                    pts.setString(6, address.getText());
                    pts.executeUpdate();
                    JOptionPane.showMessageDialog(null, "user id has been registered");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: user id has not been registered");
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnNewButton1);

        JButton back = new JButton("Back");
        Back.setBounds(71, 574, 103, 31);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dashboard newframe = new Dashboard();
                newframe.setVisible(true);
                SwingUtilities.windowForComponent(Back).dispose();
            }
        });
        Back.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(Back);

        JLabel id2 = new JLabel("Id");
        id2.setBounds(10, 109, 128, 34);
        id2.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(id2);

        id = new JTextField();
        id.setBounds(10, 150, 226, 43);
        id.setColumns(10);
        contentPane.add(id);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(382, 132, 226, 43);
        contentPane.add(textField);
    }
}

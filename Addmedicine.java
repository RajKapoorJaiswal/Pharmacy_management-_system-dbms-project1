import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Addmedicine extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField mid;
    private JTextField mn;
    private JTextField mc;
    private JTextField mq;
    private JTextField price1;
    private JComboBox<String> mfgDayComboBox;
    private JComboBox<String> mfgMonthComboBox;
    private JComboBox<String> mfgYearComboBox;
    private JComboBox<String> expDayComboBox;
    private JComboBox<String> expMonthComboBox;
    private JComboBox<String> expYearComboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Addmedicine frame = new Addmedicine();
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
    public Addmedicine() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Medicine");
        lblNewLabel.setBounds(256, 10, 236, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Medicine_ID");
        lblNewLabel_1.setBounds(25, 80, 236, 43);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Medicine_Name");
        lblNewLabel_1_1.setBounds(25, 160, 236, 43);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Company_Name");
        lblNewLabel_1_2.setBounds(25, 240, 236, 43);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Mfg_Date");
        lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_3.setBounds(25, 320, 236, 43);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Exp_Date");
        lblNewLabel_1_4.setBounds(25, 400, 236, 43);
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("Quantity");
        lblNewLabel_1_5.setBounds(25, 480, 236, 43);
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_5);

        JLabel lblNewLabel_1_6 = new JLabel("Price_per_Unit");
        lblNewLabel_1_6.setBounds(25, 560, 236, 43);
        lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel_1_6);

        mid = new JTextField();
        mid.setBounds(270, 80, 290, 37);
        contentPane.add(mid);
        mid.setColumns(10);

        mn = new JTextField();
        mn.setBounds(270, 160, 290, 37);
        contentPane.add(mn);
        mn.setColumns(10);

        mc = new JTextField();
        mc.setBounds(270, 240, 290, 37);
        contentPane.add(mc);
        mc.setColumns(10);

        // Mfg_Date Combo Boxes
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] years = new String[30];
        for (int i = 0; i < 30; i++) {
            years[i] = String.valueOf(2020 + i);
        }

        mfgDayComboBox = new JComboBox<>(days);
        mfgDayComboBox.setBounds(270, 320, 60, 37);
        contentPane.add(mfgDayComboBox);

        mfgMonthComboBox = new JComboBox<>(months);
        mfgMonthComboBox.setBounds(350, 320, 90, 37);
        contentPane.add(mfgMonthComboBox);

        mfgYearComboBox = new JComboBox<>(years);
        mfgYearComboBox.setBounds(460, 320, 90, 37);
        contentPane.add(mfgYearComboBox);

        // Exp_Date Combo Boxes
        expDayComboBox = new JComboBox<>(days);
        expDayComboBox.setBounds(270, 400, 60, 37);
        contentPane.add(expDayComboBox);

        expMonthComboBox = new JComboBox<>(months);
        expMonthComboBox.setBounds(350, 400, 90, 37);
        contentPane.add(expMonthComboBox);

        expYearComboBox = new JComboBox<>(years);
        expYearComboBox.setBounds(460, 400, 90, 37);
        contentPane.add(expYearComboBox);

        mq = new JTextField();
        mq.setBounds(270, 480, 290, 37);
        contentPane.add(mq);
        mq.setColumns(10);

        price1 = new JTextField();
        price1.setBounds(270, 560, 290, 37);
        contentPane.add(price1);
        price1.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(270, 630, 140, 33);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveMedicine();
            }
        });
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(btnSave);

        JButton Back = new JButton("Back");
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminDashboard newframe = new AdminDashboard();
                newframe.setVisible(true);
                SwingUtilities.windowForComponent(Back).dispose();
            }
        });
        Back.setFont(new Font("Tahoma", Font.BOLD, 20));
        Back.setBounds(420, 630, 140, 33);
        contentPane.add(Back);
    }

    private void saveMedicine() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");
            String sql = "INSERT INTO medicine2 VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pts = con.prepareStatement(sql);
            pts.setString(1, mid.getText());
            pts.setString(2, mn.getText());
            pts.setString(3, mc.getText());

            // Constructing Manufacturing Date
            String mfgDate = mfgYearComboBox.getSelectedItem() + "-" + (mfgMonthComboBox.getSelectedIndex() + 1) + "-" + mfgDayComboBox.getSelectedItem();
            pts.setString(4, mfgDate);

            // Constructing Expiry Date
            String expDate = expYearComboBox.getSelectedItem() + "-" + (expMonthComboBox.getSelectedIndex() + 1) + "-" + expDayComboBox.getSelectedItem();
            pts.setString(5, expDate);

            pts.setString(6, mq.getText());
            pts.setString(7, price1.getText());
            pts.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medicine has been registered");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: Medicine has not been registered");
            ex.printStackTrace();
        }
    }
}

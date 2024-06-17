import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dashboard frame = new Dashboard();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Dashboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 587, 515);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("User Dashboard");
        lblNewLabel.setBounds(158, 34, 326, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        contentPane.add(lblNewLabel);

        JButton btnAddUser = new JButton("Add User");
        btnAddUser.setBounds(77, 193, 168, 43);
        btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ADDUSER frame = new ADDUSER();
                frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnAddUser);

        JButton btnViewUser = new JButton("View User");
        btnViewUser.setBounds(77, 276, 168, 43);
        btnViewUser.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnViewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VIEWUSER frame = new VIEWUSER();
                frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnViewUser);

        JButton btnUpdateUser = new JButton("Update User");
        btnUpdateUser.setBounds(77, 373, 168, 43);
        btnUpdateUser.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnUpdateUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateuser frame = new updateuser();
                frame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnUpdateUser);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(772, 10, 101, 33);
        btnLogout.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dashboard newframe = new Dashboard();
                newframe.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnLogout);
        
        JButton Login = new JButton("Login");
        Login.setBounds(349, 281, 111, 33);
        Login.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
					AdminDashboard newframe = new AdminDashboard();
				    newframe.setVisible(true);
					SwingUtilities.windowForComponent(Login).dispose();
        	}
        });
        Login.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(Login);
        
        JButton Back = new JButton("Back");
        Back.setBounds(349, 378, 111, 33);
        Back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
					login newframe = new login();
				    newframe.setVisible(true);
					SwingUtilities.windowForComponent(Back).dispose();
        	}
        });
        Back.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(Back);
    }
}

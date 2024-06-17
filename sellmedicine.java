import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class sellmedicine extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JTable table;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_2;

    // List to store selected medicines
    private List<String[]> selectedMedicines = new ArrayList<>();
    private JTable table_1;
	private String output;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    sellmedicine frame = new sellmedicine();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public sellmedicine() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1047, 747);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(161, 46, 199, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        Calendar cp = Calendar.getInstance();
        output = sdf.format(cp.getTime());
        JLabel lblNewLabel = new JLabel("Medicine_Name");
        lblNewLabel.setBounds(10, 43, 141, 30);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBackground(new Color(240, 240, 240));
        contentPane.add(lblNewLabel);

        // Add a KeyListener to the text field to handle search suggestions
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchMedicines(textField.getText());
            }
        });

        JButton btnNewButton = new JButton("Search");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchMedicines(textField.getText());
            }
        });
        btnNewButton.setBounds(383, 43, 102, 30);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(btnNewButton);

        JLabel lblPriceperunit = new JLabel("Price_per_Unit");
        lblPriceperunit.setBounds(10, 102, 141, 30);
        lblPriceperunit.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPriceperunit.setBackground(UIManager.getColor("Button.background"));
        contentPane.add(lblPriceperunit);

        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(10, 147, 141, 30);
        lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblQuantity.setBackground(UIManager.getColor("Button.background"));
        contentPane.add(lblQuantity);

        JLabel lblTotalprice = new JLabel("Total_Price");
        lblTotalprice.setBounds(10, 196, 141, 30);
        lblTotalprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTotalprice.setBackground(UIManager.getColor("Button.background"));
        contentPane.add(lblTotalprice);

        textField_1 = new JTextField();
        textField_1.setBounds(161, 102, 199, 30);
        textField_1.setColumns(10);
        contentPane.add(textField_1);

        textField_3 = new JTextField();
        textField_3.setBounds(161, 199, 199, 30);
        textField_3.setColumns(10);
        contentPane.add(textField_3);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 490, 890, 166);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Medicine_ID", "Medicine_Name", "Company_Name", "Quantity", "Price"
            }
        ));

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double ppu = Double.parseDouble(textField_1.getText());
                    int quantity = Integer.parseInt(textField_2.getText());
                    double totalPrice = ppu * quantity;
                    textField_3.setText(String.valueOf(totalPrice));
                    textField_4.setText(String.valueOf(totalPrice)); // Update the total price field
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for price and quantity.");
                }
            }
        });
        btnCalculate.setBounds(191, 249, 124, 38);
        btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(btnCalculate);

        JButton btnBill = new JButton("Bill");
        btnBill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder bill = new StringBuilder();
                bill.append("=============================================\n");
                bill.append("                                Medicine Bill\n");
                bill.append("=============================================\n\n");
                bill.append("Date:"+output+"\n");
                bill.append(String.format("%-20s %-20s %-10s %-10s\n", "Medicine_Name", "Price_per_Unit", "Quantity", "Total"));

                double totalAmount = 0.0;

                for (String[] medicine : selectedMedicines) {
                    String medicineName = medicine[1];
                    String pricePerUnit = medicine[4];
                    String quantity = medicine[5];
                    String total = String.valueOf(Double.parseDouble(pricePerUnit) * Double.parseDouble(quantity));

                    bill.append(String.format("%-18s   %-28s %-15s %-15s\n", medicineName, pricePerUnit, quantity, total));
                    totalAmount += Double.parseDouble(total);
                    // Decrease the medicine quantity in the database
                    updateMedicineQuantity(medicineName, Integer.parseInt(quantity));
                }

                bill.append("\nTotal Amount: " + totalAmount + "\n");

                JTextArea textArea = new JTextArea(bill.toString());
                textArea.setFont(new Font("Arial", Font.PLAIN, 14));
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                JOptionPane.showMessageDialog(null, scrollPane, "Medicine Bill", JOptionPane.PLAIN_MESSAGE);
                try {
                    textArea.print();
                } catch (PrinterException e3) {
                    e3.printStackTrace();
                }
            }
        });
        btnBill.setBounds(623, 666, 102, 30);
        btnBill.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(btnBill);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminDashboard newframe = new AdminDashboard();
                newframe.setVisible(true);
                dispose(); // Dispose the current frame directly
            }
        });
        btnBack.setBounds(126, 666, 102, 30);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(btnBack);

        JButton btnShow = new JButton("Show");
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllMedicines();
            }
        });
        btnShow.setBounds(405, 666, 102, 30);
        btnShow.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(btnShow);

        JLabel lblTotal = new JLabel("Paying amount");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTotal.setBackground(UIManager.getColor("Button.background"));
        lblTotal.setBounds(10, 294, 141, 30);
        contentPane.add(lblTotal);

        JLabel lblPayingAmount = new JLabel("Given amount");
        lblPayingAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPayingAmount.setBackground(UIManager.getColor("Button.background"));
        lblPayingAmount.setBounds(10, 351, 141, 30);
        contentPane.add(lblPayingAmount);

        JLabel lblBalance = new JLabel("Return");
        lblBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBalance.setBackground(UIManager.getColor("Button.background"));
        lblBalance.setBounds(10, 402, 141, 30);
        contentPane.add(lblBalance);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(161, 297, 199, 30);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(161, 354, 199, 30);
        contentPane.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(161, 405, 199, 30);
        contentPane.add(textField_6);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(161, 150, 199, 30);
        contentPane.add(textField_2);

        // Button to navigate to the scanner page
        JButton btnScanner = new JButton("Scanner");
        btnScanner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scanner scannerPage = new scanner();
                scannerPage.setVisible(true);
                dispose(); // Dispose the current frame
            }
        });
        btnScanner.setBounds(791, 660, 102, 30);
        btnScanner.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(btnScanner);

        JButton btnCalculated = new JButton("Calculated");
        btnCalculated.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double total = Double.parseDouble(textField_4.getText());
                    double givenAmount = Double.parseDouble(textField_5.getText());
                    double returnAmount = givenAmount - total;
                    textField_6.setText(String.valueOf(returnAmount));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
                }
            }
        });
        btnCalculated.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCalculated.setBounds(201, 445, 124, 38);
        contentPane.add(btnCalculated);

        // Button to add medicine to the list
        JButton btnAddToList = new JButton("Add to List");
        btnAddToList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String[] medicine = new String[6];
                    for (int i = 0; i < 5; i++) {
                        medicine[i] = (String) model.getValueAt(selectedRow, i);
                    }
                    medicine[5] = textField_2.getText(); // Quantity
                    selectedMedicines.add(medicine);

                    // Update the cart table
                    DefaultTableModel cartModel = (DefaultTableModel) table_1.getModel();
                    cartModel.addRow(medicine);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a medicine from the table.");
                }
            }
        });
        btnAddToList.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAddToList.setBounds(540, 135, 141, 30);
        contentPane.add(btnAddToList);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(440, 175, 535, 231);
       
        contentPane.add(scrollPane_1);

        table_1 = new JTable();
        scrollPane_1.setViewportView(table_1);
        table_1.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Medicine_ID", "Medicine_Name", "Company_Name", "Quantity", "Price"
            }
        ));
        
        JLabel lblSellMedicine = new JLabel("SELL MEDICINE");
        lblSellMedicine.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSellMedicine.setBackground(UIManager.getColor("Button.background"));
        lblSellMedicine.setBounds(440, 0, 141, 30);
        contentPane.add(lblSellMedicine);
        table_1.getColumnModel().getColumn(1).setPreferredWidth(87);
        table_1.getColumnModel().getColumn(2).setPreferredWidth(89);
    }

    // Method to search medicines by partial match
    private void searchMedicines(String searchQuery) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");
            String query = "SELECT * FROM medicine2 WHERE Medicine_Name LIKE ?";
            PreparedStatement pts = con.prepareStatement(query);
            pts.setString(1, "%" + textField.getText() + "%");
            ResultSet rs = pts.executeQuery();
            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            dt.setRowCount(0);
            while (rs.next()) {
                Object[] row = {
                    rs.getString("Medicine_ID"),
                    rs.getString("Medicine_Name"),
                    rs.getString("Company_Name"),
                    rs.getString("Quantity"),
                    rs.getString("Price_per_Unit")
                };
                if (Integer.parseInt(rs.getString("Quantity")) == 0) {
                    JOptionPane.showMessageDialog(null, "Medicine not available in shop.");
                    return;
                }
                dt.addRow(row);
            }
            if (dt.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Medicine not available in shop.");
            } else {
                textField_1.setText(String.valueOf(dt.getValueAt(0, 4))); // Show the price of the first medicine
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    // Method to show all medicines
    private void showAllMedicines() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");
            String sql = "SELECT * FROM medicine2";
            PreparedStatement pts = con.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();
            DefaultTableModel dt = (DefaultTableModel) table.getModel();
            dt.setRowCount(0);
            while (rs.next()) {
                Object[] row = {
                    rs.getString("Medicine_ID"),
                    rs.getString("Medicine_Name"),
                    rs.getString("Company_Name"),
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
    
    // Method to update medicine quantity after selling
    private void updateMedicineQuantity(String medicineName, int quantitySold) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medicine", "root", "raj@2004");
            String query = "UPDATE medicine2 SET Quantity = Quantity - ? WHERE Medicine_Name = ?";
            PreparedStatement pts = con.prepareStatement(query);
            pts.setInt(1, quantitySold);
            pts.setString(2, medicineName);
            pts.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}

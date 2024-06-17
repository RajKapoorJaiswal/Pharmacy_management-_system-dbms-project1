import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class scanner extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    scanner frame = new scanner();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public scanner() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 713, 549);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // Button to go back to the main frame
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(26, 284, 102, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sellmedicine mainFrame = new sellmedicine();
                mainFrame.setVisible(true);
                dispose(); // Dispose the current frame
            }
        });
        contentPane.setLayout(null);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(btnBack);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(176, 33, 460, 435);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rajkapoor\\OneDrive\\Documents\\scc.jpg"));
        contentPane.add(lblNewLabel);
        
        JButton btnDone = new JButton("Done");
        btnDone.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		sellmedicine mainFrame = new sellmedicine();
                mainFrame.setVisible(true);
                dispose(); // Dispose the current frame
        	}
        });
        btnDone.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDone.setBounds(37, 425, 102, 30);
        contentPane.add(btnDone);
    }
}

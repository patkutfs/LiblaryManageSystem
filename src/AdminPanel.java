import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminPanel::new);
    }
    public AdminPanel() {
        setTitle("Admin Panel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.setBackground(Color.WHITE);

        JLabel adminLabel = new JLabel("Admin Panel");
        adminLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        topPanel.add(adminLabel, BorderLayout.WEST);

        JButton manageBooksButton = new JButton("Manage Books");
        manageBooksButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        manageBooksButton.setFocusPainted(false);
        manageBooksButton.addActionListener(e -> new BookManager());

        topPanel.add(manageBooksButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        bottomPanel.setBackground(Color.WHITE);

        JButton manageUsersButton = new JButton("Manage Users");
        manageUsersButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        manageUsersButton.setFocusPainted(false);
        manageUsersButton.setPreferredSize(new Dimension(140, 35));
        manageUsersButton.addActionListener(e -> showMessage());

        bottomPanel.add(manageUsersButton);

        add(bottomPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    private void showMessage() {
        JOptionPane.showMessageDialog(this, "31", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}

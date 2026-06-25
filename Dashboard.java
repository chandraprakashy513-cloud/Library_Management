import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Library Dashboard");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel header = new JPanel();
        header.setBackground(new Color(0, 102, 204));

        JLabel title = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 26));

        header.add(title);

        JPanel cards = new JPanel(new GridLayout(1, 3, 20, 20));
        cards.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        JPanel card1 = createCard("Total Books", "0");
        JPanel card2 = createCard("Available", "0");
        JPanel card3 = createCard("Issued", "0");

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        JButton manageBtn = new JButton("Manage Books");
        manageBtn.setFont(new Font("Arial", Font.BOLD, 18));

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFont(new Font("Arial", Font.BOLD, 18));

        manageBtn.addActionListener(e -> new LibraryManagementSystem());

        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginPage();
        });

        JPanel bottom = new JPanel();
        bottom.add(manageBtn);
        bottom.add(logoutBtn);

        add(header, BorderLayout.NORTH);
        add(cards, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createCard(String title, String value) {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel lblTitle = new JLabel(title, SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblValue = new JLabel(value, SwingConstants.CENTER);
        lblValue.setFont(new Font("Arial", Font.BOLD, 32));

        panel.add(lblTitle, BorderLayout.NORTH);
        panel.add(lblValue, BorderLayout.CENTER);

        return panel;
    }
}
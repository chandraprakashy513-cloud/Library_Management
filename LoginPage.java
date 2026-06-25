import java.awt.*;
import javax.swing.*;

public class LoginPage extends JFrame {

    JTextField username;
    JPasswordField password;

    LoginPage() {

        setTitle("Library Management System");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ⭐ Modern Dark Theme Background
        panel.setBackground(new Color(44, 62, 80));

        JLabel title = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        title.setBounds(60, 30, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.WHITE);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(80, 90, 100, 25);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        username = new JTextField();
        username.setBounds(180, 90, 180, 30);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(80, 140, 100, 25);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        password = new JPasswordField();
        password.setBounds(180, 140, 180, 30);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(180, 200, 120, 35);

        // ⭐ Button modern styling
        loginBtn.setBackground(new Color(46, 204, 113));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        loginBtn.setFont(new Font("Arial", Font.BOLD, 14));
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        loginBtn.addActionListener(e -> {

            String user = username.getText();
            String pass = String.valueOf(password.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                dispose();
                new Dashboard(); // make sure Dashboard class exists
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        });

        panel.add(title);
        panel.add(userLabel);
        panel.add(username);
        panel.add(passLabel);
        panel.add(password);
        panel.add(loginBtn);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
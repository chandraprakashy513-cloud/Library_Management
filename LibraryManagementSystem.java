import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LibraryManagementSystem extends JFrame {

    JTextField txtBookName, txtSearch;
    JTable table;
    DefaultTableModel model;

    JLabel totalLabel, availableLabel, issuedLabel;

    int bookId = 1;

    public LibraryManagementSystem() {

        setTitle("Library Management System");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(0, 102, 204));

        JLabel title = new JLabel("LIBRARY MANAGEMENT SYSTEM");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        header.add(title);

        // Input Panel
        JPanel inputPanel = new JPanel();

        inputPanel.add(new JLabel("Book Name:"));
        txtBookName = new JTextField(15);
        inputPanel.add(txtBookName);

        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnIssue = new JButton("Issue");
        JButton btnReturn = new JButton("Return");

        inputPanel.add(btnAdd);
        inputPanel.add(btnDelete);
        inputPanel.add(btnIssue);
        inputPanel.add(btnReturn);

        inputPanel.add(new JLabel("Search:"));

        txtSearch = new JTextField(10);
        inputPanel.add(txtSearch);

        JButton btnSearch = new JButton("Search");
        inputPanel.add(btnSearch);

        // Table
        String[] columns = {
                "Book ID",
                "Book Name",
                "Status"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);
        table.setRowHeight(25);

        JScrollPane scrollPane =
                new JScrollPane(table);

        // Counter Panel
        JPanel counterPanel = new JPanel();

        totalLabel = new JLabel("Total Books: 0");
        availableLabel = new JLabel("Available: 0");
        issuedLabel = new JLabel("Issued: 0");

        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        availableLabel.setFont(new Font("Arial", Font.BOLD, 16));
        issuedLabel.setFont(new Font("Arial", Font.BOLD, 16));

        counterPanel.add(totalLabel);
        counterPanel.add(Box.createHorizontalStrut(30));
        counterPanel.add(availableLabel);
        counterPanel.add(Box.createHorizontalStrut(30));
        counterPanel.add(issuedLabel);

        // Add Book
        btnAdd.addActionListener(e -> {

            String name = txtBookName.getText().trim();

            if (!name.isEmpty()) {

                model.addRow(new Object[]{
                        bookId++,
                        name,
                        "Available"
                });

                txtBookName.setText("");
                updateCounters();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Enter Book Name");
            }
        });

        // Delete Book
        btnDelete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                model.removeRow(row);
                updateCounters();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Select a Book");
            }
        });

        // Issue Book
        btnIssue.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                model.setValueAt("Issued", row, 2);
                updateCounters();
            }
        });

        // Return Book
        btnReturn.addActionListener(e -> {

            int row = table.getSelectedRow();

            if (row >= 0) {

                model.setValueAt("Available", row, 2);
                updateCounters();
            }
        });

        // Search Book
        btnSearch.addActionListener(e -> {

            String search =
                    txtSearch.getText().toLowerCase();

            boolean found = false;

            for (int i = 0; i < table.getRowCount(); i++) {

                String name =
                        table.getValueAt(i, 1)
                                .toString()
                                .toLowerCase();

                if (name.contains(search)) {

                    table.setRowSelectionInterval(i, i);
                    found = true;
                    break;
                }
            }

            if (!found) {

                JOptionPane.showMessageDialog(this,
                        "Book Not Found");
            }
        });

        setLayout(new BorderLayout());

        add(header, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        add(counterPanel, BorderLayout.PAGE_END);

        setVisible(true);
    }

    private void updateCounters() {

        int total = table.getRowCount();
        int available = 0;
        int issued = 0;

        for (int i = 0; i < table.getRowCount(); i++) {

            String status =
                    table.getValueAt(i, 2).toString();

            if (status.equals("Available"))
                available++;

            if (status.equals("Issued"))
                issued++;
        }

        totalLabel.setText("Total Books: " + total);
        availableLabel.setText("Available: " + available);
        issuedLabel.setText("Issued: " + issued);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new LibraryManagementSystem());
    }
}
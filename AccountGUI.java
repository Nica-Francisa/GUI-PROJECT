import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountGUI extends JFrame {

    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    // Login Components
    JTextField loginUsernameField = new JTextField(15);
    JPasswordField loginPasswordField = new JPasswordField(15);

    // Create Account Components
    JTextField nameField = new JTextField(15);
    JTextField phoneField = new JTextField(15);
    JTextField createUsernameField = new JTextField(15);
    JTextField emailField = new JTextField(15);
    JPasswordField createPasswordField = new JPasswordField(15);
    JPasswordField confirmPasswordField = new JPasswordField(15);

    // Profile Panel Buttons
    JButton signOutBtn = new JButton("SIGN OUT");

    public AccountGUI() {
        setTitle("Account Management");
        setSize(750, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add Panels to mainPanel with CardLayout
        mainPanel.add(loginPanel(), "LOGIN");
        mainPanel.add(createAccountPanel(), "CREATE_ACCOUNT");
        mainPanel.add(profilePanel(), "PROFILE");

        add(mainPanel);
        cardLayout.show(mainPanel, "LOGIN");
    }

    // LOGIN PANEL
    private JPanel loginPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 196, 231)); 
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("MY ACCOUNT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titleLabel.setPreferredSize(new Dimension(750, 30));

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(panel.getBackground());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 80, 80, 80));

        JLabel heading = new JLabel("LOG INTO YOUR ACCOUNT", SwingConstants.CENTER);
        heading.setFont(new Font("Verdana", Font.BOLD, 18));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(heading);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Username Panel
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usernamePanel.setOpaque(false);
        JLabel usernameLabel = new JLabel("USERNAME / EMAIL : ");
        usernamePanel.add(usernameLabel);
        loginUsernameField.setBackground(new Color(90, 130, 190));
        loginUsernameField.setForeground(Color.WHITE);
        loginUsernameField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        usernamePanel.add(loginUsernameField);

        // Password Panel
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.setOpaque(false);
        JLabel passwordLabel = new JLabel("PASSWORD : ");
        passwordPanel.add(passwordLabel);
        loginPasswordField.setBackground(new Color(90, 130, 190));
        loginPasswordField.setForeground(Color.WHITE);
        loginPasswordField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        passwordPanel.add(loginPasswordField);

        centerPanel.add(usernamePanel);
        centerPanel.add(passwordPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        // Buttons Panel
        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.setLayout(new GridLayout(2, 1, 0, 5));

        JButton signInButton = new JButton("SIGN IN");
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusPainted(false);

        JButton goToCreateButton = new JButton("CREATE ACCOUNT");
        goToCreateButton.setBackground(Color.WHITE);
        goToCreateButton.setForeground(Color.BLACK);
        goToCreateButton.setFocusPainted(false);

        btnPanel.add(signInButton);
        btnPanel.add(goToCreateButton);

        centerPanel.add(btnPanel);

        // Add listeners
        signInButton.addActionListener(e -> signInAction());
        goToCreateButton.addActionListener(e -> {
            clearCreateFields();
            cardLayout.show(mainPanel, "CREATE_ACCOUNT");
        });

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }

    // CREATE ACCOUNT PANEL
    private JPanel createAccountPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 196, 231));
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("CREATE ACCOUNT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titleLabel.setPreferredSize(new Dimension(750, 30));

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(panel.getBackground());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 60, 80));

        JPanel formPanel = new JPanel();
        formPanel.setBackground(centerPanel.getBackground());
        formPanel.setLayout(new GridLayout(6, 2, 10, 15));

        // Add Labels and Fields
        formPanel.add(new JLabel("NAME :"));
        setupTextField(nameField);
        formPanel.add(nameField);

        formPanel.add(new JLabel("PHONE NUMBER :"));
        setupTextField(phoneField);
        formPanel.add(phoneField);

        formPanel.add(new JLabel("USERNAME :"));
        setupTextField(createUsernameField);
        formPanel.add(createUsernameField);

        formPanel.add(new JLabel("EMAIL :"));
        setupTextField(emailField);
        formPanel.add(emailField);

        formPanel.add(new JLabel("PASSWORD :"));
        setupPasswordField(createPasswordField);
        formPanel.add(createPasswordField);

        formPanel.add(new JLabel("CONFIRM PASSWORD :"));
        setupPasswordField(confirmPasswordField);
        formPanel.add(confirmPasswordField);

        centerPanel.add(formPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        JButton createAccountButton = new JButton("CREATE ACCOUNT");
        createAccountButton.setBackground(Color.WHITE);
        createAccountButton.setFocusPainted(false);
        createAccountButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(createAccountButton);

        createAccountButton.addActionListener(e -> createAccountAction());

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }

    // PROFILE PANEL
    private JPanel profilePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(64, 106, 195));
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("PROFILE", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        titleLabel.setPreferredSize(new Dimension(750, 30));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(new Color(173, 196, 231));
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));

        // Strings for options
        String[] options = {
                "My Orders",
                "My Details",
                "Gift Cards / Vouchers",
                "Need Help?",
                "Tell me what you think"
        };

        for (String option : options) {
            JButton btn = createOptionButton(option);
            optionsPanel.add(btn);
            optionsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JPanel signOutPanel = new JPanel();
        signOutPanel.setBackground(panel.getBackground());
        signOutBtn.setBackground(Color.BLACK);
        signOutBtn.setForeground(Color.WHITE);
        signOutBtn.setFocusPainted(false);
        signOutBtn.setPreferredSize(new Dimension(100, 30));
        signOutPanel.add(signOutBtn);

        signOutBtn.addActionListener(e -> {
            clearLoginFields();
            cardLayout.show(mainPanel, "LOGIN");
        });

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(optionsPanel, BorderLayout.CENTER);
        panel.add(signOutPanel, BorderLayout.SOUTH);

        return panel;
    }

    // Helper to create option buttons with arrow on right
    private JButton createOptionButton(String text) {
        JButton btn = new JButton(text + "    \u2192");
        btn.setBackground(new Color(173, 196, 231));
        btn.setFocusPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn.setPreferredSize(new Dimension(600, 40));
        btn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        btn.addActionListener(e -> JOptionPane.showMessageDialog(this, "You clicked: " + text));
        return btn;
    }

    // Helper to style text field for Create Panel
    private void setupTextField(JTextField field) {
        field.setBackground(new Color(90, 130, 190));
        field.setForeground(Color.WHITE);
        field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void setupPasswordField(JPasswordField field) {
        field.setBackground(new Color(90, 130, 190));
        field.setForeground(Color.WHITE);
        field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void signInAction() {
        String username = loginUsernameField.getText().trim();
        String password = new String(loginPasswordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Dummy auth: accept if username = "user" and password = "pass"
        if (username.equals("user") && password.equals("pass")) {
            JOptionPane.showMessageDialog(this, "Welcome, " + username + "!");
            clearLoginFields();
            cardLayout.show(mainPanel, "PROFILE");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createAccountAction() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String username = createUsernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(createPasswordField.getPassword());
        String confirm = new String(confirmPasswordField.getPassword());

        if (name.isEmpty() || phone.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simulate account creation success
        JOptionPane.showMessageDialog(this, "Account created successfully!\nYou can now log in.");
        clearCreateFields();
        cardLayout.show(mainPanel, "LOGIN");
    }

    // Clears login fields
    private void clearLoginFields() {
        loginUsernameField.setText("");
        loginPasswordField.setText("");
    }

    // Clears create account fields
    private void clearCreateFields() {
        nameField.setText("");
        phoneField.setText("");
        createUsernameField.setText("");
        emailField.setText("");
        createPasswordField.setText("");
        confirmPasswordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AccountGUI gui = new AccountGUI();
            gui.setVisible(true);
        });
    }
}

import javax.swing.*;
import java.awt.*;

public class WireFrame {

    private JLabel congratsLabel; 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WireFrame());
    }

    public WireFrame() {
        JFrame frame = new JFrame("Registration App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel welcomePanel = createWelcomePanel(cardLayout, mainPanel);
        JPanel formPanel = createFormPanel(cardLayout, mainPanel);
        JPanel completePanel = createCompletePanel(cardLayout, mainPanel);

        mainPanel.add(welcomePanel, "welcome");
        mainPanel.add(formPanel, "form");
        mainPanel.add(completePanel, "complete");

        frame.add(mainPanel);
        frame.setVisible(true);
        
        cardLayout.show(mainPanel, "welcome");
    }

    private JPanel createWelcomePanel(CardLayout layout, JPanel mainPanel) {
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(Color.DARK_GRAY);
        outerPanel.setLayout(new GridBagLayout());
       

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.LIGHT_GRAY);
        innerPanel.setPreferredSize(new Dimension(300, 200));
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("WELCOME!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        JButton getStartedButton = new JButton("Get Started");
        getStartedButton.setFocusPainted(false);
        getStartedButton.setBackground(Color.GRAY);
        getStartedButton.setForeground(Color.WHITE);
        getStartedButton.setFont(new Font("Arial", Font.PLAIN, 16));
        getStartedButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        getStartedButton.addActionListener(e -> layout.show(mainPanel, "form"));

        innerPanel.add(welcomeLabel);
        innerPanel.add(Box.createVerticalStrut(15));
        innerPanel.add(getStartedButton);

        outerPanel.add(innerPanel);
        return outerPanel;
    }

    private JPanel createFormPanel(CardLayout layout, JPanel mainPanel) {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("FILL UP", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setOpaque(true);
        title.setBackground(Color.DARK_GRAY);
        title.setForeground(Color.WHITE);
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
       
        JTextField lastName = new JTextField();
        JTextField middleName = new JTextField();
        JTextField firstName = new JTextField();
        JTextField dob = new JTextField("MM/DD/YYYY");
        JTextField email = new JTextField();
        JTextField username = new JTextField();
        JCheckBox confirm = new JCheckBox("All this information is true");

        formPanel.add(new JLabel("Lastname:")); formPanel.add(lastName);
        formPanel.add(new JLabel("Middlename:")); formPanel.add(middleName);
        formPanel.add(new JLabel("Firstname:")); formPanel.add(firstName);
        formPanel.add(new JLabel("Date of Birth:")); formPanel.add(dob);
        formPanel.add(new JLabel("Email Address:")); formPanel.add(email);
        formPanel.add(new JLabel("Username:")); formPanel.add(username);
        formPanel.add(confirm);

        JButton doneButton = new JButton("Done");
        doneButton.setBackground(Color.GRAY);
        doneButton.setForeground(Color.WHITE);
        doneButton.addActionListener(e -> {
            if (!confirm.isSelected()) {
                JOptionPane.showMessageDialog(panel, "Please confirm that all information is true.");
            } else if (username.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(panel, "Please enter your username.");
            } else {
                congratsLabel.setText("<html><center>Congratulations @" + username.getText().trim() + "!<br>Registration Complete</center></html>");
                layout.show(mainPanel, "complete");
            }
        });

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(doneButton, BorderLayout.SOUTH);
        return panel;
    }

  private JPanel createCompletePanel(CardLayout layout, JPanel mainPanel) {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(Color.LIGHT_GRAY);

    congratsLabel = new JLabel("<html><center>Congratulations @!<br>Registration Complete</center></html>",
            SwingConstants.CENTER);
    congratsLabel.setFont(new Font("Arial", Font.BOLD, 18));
    congratsLabel.setBorder(BorderFactory.createEmptyBorder(20, 40, 30, 20));
    congratsLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 

    JButton fillUpAgain = new JButton("FILL UP AGAIN");
    fillUpAgain.setBackground(Color.GRAY);
    fillUpAgain.setForeground(Color.WHITE);
    fillUpAgain.setFocusPainted(false);
    fillUpAgain.setFont(new Font("Arial", Font.PLAIN, 14));
    fillUpAgain.setAlignmentX(Component.CENTER_ALIGNMENT); 
    
    fillUpAgain.addActionListener(e -> layout.show(mainPanel, "form"));

    JPanel center = new JPanel();
    center.setBackground(Color.LIGHT_GRAY);
    center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

    center.add(Box.createVerticalGlue()); 
    center.add(congratsLabel);
    center.add(Box.createVerticalStrut(10));
    center.add(fillUpAgain);
    center.add(Box.createVerticalGlue());

    panel.add(center, BorderLayout.CENTER);
    return panel;
 }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SelliTApp {
    public static void main(String[] args) {
        new LoginPage(); 
        
    }
}

class LoginPage extends JFrame {
    JTextField usernameField;
    JPasswordField passwordField;
    JCheckBox agreeBox;

    public LoginPage() {
        setTitle("SelliT");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel title = new JLabel("SelliT");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBounds(110, 30, 100, 40);
        add(title);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 80, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(50, 125, 200, 30);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 170, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 195, 200, 30);
        add(passwordField);

        agreeBox = new JCheckBox("Agree to terms and agreements");
        agreeBox.setBackground(Color.LIGHT_GRAY);
        agreeBox.setBounds(50, 235, 220, 25);
        add(agreeBox);

        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(50, 270, 200, 40);
        loginButton.setBackground(Color.ORANGE);
        loginButton.setForeground(Color.BLACK);
        add(loginButton);

        loginButton.addActionListener((ActionEvent e) -> {
            if (!agreeBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please agree to the terms first.");
            } else if (usernameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter your username.");
            } else {
                
                new ShoppingPage (usernameField.getText());
                dispose(); 
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }
}

class ShoppingPage extends JFrame {
    public ShoppingPage(String username) {
        setTitle("SelliT Shopping");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel userLabel = new JLabel(username, SwingConstants.CENTER);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setBounds(90, 40, 120, 25);
        add(userLabel);

        JLabel title = new JLabel("SHOPPING", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(70, 80, 160, 30);
        add(title);

        JLabel shirtIcon = new JLabel("🧥", SwingConstants.CENTER);
        shirtIcon.setBounds(100, 120, 100, 100);
        add(shirtIcon);

        JButton shopButton = new JButton("Go Shopping");
        shopButton.setBounds(70, 240, 160, 40);
        shopButton.setBackground(Color.ORANGE);
        add(shopButton);

        JLabel homeIcon = new JLabel("🏠", SwingConstants.CENTER);
        homeIcon.setBounds(40, 320, 40, 30);
        add(homeIcon);

        JLabel cartIcon = new JLabel("🛒", SwingConstants.CENTER);
        cartIcon.setBounds(125, 320, 40, 30);
        add(cartIcon);

        JLabel settingsIcon = new JLabel("⚙️", SwingConstants.CENTER);
        settingsIcon.setBounds(210, 320, 40, 30);
        add(settingsIcon);

        shopButton.addActionListener((ActionEvent e) -> {
            new ProductPage(username);
            dispose();
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }
}

class ProductPage extends JFrame {
    int smallCount = 0;
    int mediumCount = 0;

    public ProductPage(String username) {
        setTitle("SelliT - Products");
        setSize(300, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel userLabel = new JLabel(username, SwingConstants.CENTER);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setBounds(80, 20, 140, 25);
        add(userLabel);

        JLabel shirtIcon = new JLabel("🧥", SwingConstants.CENTER);
        shirtIcon.setBounds(100, 50, 100, 100);
        add(shirtIcon);

        JLabel smallLabel = new JLabel("Small  ₱50 - ₱60");
        smallLabel.setBounds(60, 160, 120, 25);
        add(smallLabel);

        JButton minusSmall = new JButton("-");
        minusSmall.setBounds(60, 190, 45, 30);
        add(minusSmall);

        JLabel smallQty = new JLabel("0", SwingConstants.CENTER);
        smallQty.setBounds(110, 190, 45, 30);
        smallQty.setOpaque(true);
        smallQty.setBackground(Color.WHITE);
        add(smallQty);

        JButton plusSmall = new JButton("+");
        plusSmall.setBounds(160, 190, 45, 30);
        add(plusSmall);

        JLabel mediumLabel = new JLabel("Medium ₱50 - ₱60");
        mediumLabel.setBounds(60, 230, 130, 25);
        add(mediumLabel);

        JButton minusMedium = new JButton("-");
        minusMedium.setBounds(60, 260, 45, 30);
        add(minusMedium);

        JLabel mediumQty = new JLabel("0", SwingConstants.CENTER);
        mediumQty.setBounds(110, 260, 45, 30);
        mediumQty.setOpaque(true);
        mediumQty.setBackground(Color.WHITE);
        add(mediumQty);

        JButton plusMedium = new JButton("+");
        plusMedium.setBounds(160, 260, 45, 30);
        add(plusMedium);

        JButton buyButton = new JButton("Buy");
        buyButton.setBounds(50, 310, 80, 40);
        buyButton.setBackground(Color.ORANGE);
        add(buyButton);

        JButton cartButton = new JButton("Cart");
        cartButton.setBounds(150, 310, 80, 40);
        cartButton.setBackground(Color.ORANGE);
        add(cartButton);

        plusSmall.addActionListener(e -> {
            smallCount++;
            smallQty.setText(String.valueOf(smallCount));
        });

        minusSmall.addActionListener(e -> {
            if (smallCount > 0) smallCount--;
            smallQty.setText(String.valueOf(smallCount));
        });

        plusMedium.addActionListener(e -> {
            mediumCount++;
            mediumQty.setText(String.valueOf(mediumCount));
        });

        minusMedium.addActionListener(e -> {
            if (mediumCount > 0) mediumCount--;
            mediumQty.setText(String.valueOf(mediumCount));
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }
}

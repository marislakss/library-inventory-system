package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
// The LoginWindow class represents a login window with UI components and associated event handling.
public class LoginWindow extends JFrame implements ActionListener {

    // Declare UI components
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JButton registerButton;
    private final JButton resetPasswordButton;
    private boolean loggedIn = false;

    // Declare text file paths
    public static final String USERS_FILE = "users.txt";

    InventoryManagementGUI gui;

    public LoginWindow() {
        // Configure the login window
        super("Login");
        LookAndFeelUtil.setLookAndFeel();
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set up the panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        add(panel);

        // Add Username Label and TextField.
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.insets = new Insets(5, 5, 5, 5);
        panel.add(usernameLabel, c1);
        c1.gridx = 1;
        c1.gridy = 0;
        c1.fill = GridBagConstraints.HORIZONTAL;
        panel.add(usernameField, c1);

        // Add Password Label and TextField.
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 1;
        c2.insets = new Insets(5, 5, 5, 5);
        panel.add(passwordLabel, c2);
        c2.gridx = 1;
        c2.gridy = 1;
        c2.fill = GridBagConstraints.HORIZONTAL;
        panel.add(passwordField, c2);

        // Add Login Button.
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(0, 102, 204));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 1;
        c3.gridy = 2;
        c3.anchor = GridBagConstraints.LINE_END;
        c3.insets = new Insets(10, 0, 0, 0);
        panel.add(loginButton, c3);

        // Add Register Button.
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(255, 153, 0));
        registerButton.setFocusPainted(false);
        registerButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridx = 1;
        c4.gridy = 3;
        c4.anchor = GridBagConstraints.LINE_END;
        c4.insets = new Insets(10, 0, 0, 0);
        panel.add(registerButton, c4);

        // Add Reset Password Button.
        resetPasswordButton = new JButton("Reset password");
        resetPasswordButton.addActionListener(this);
        resetPasswordButton.setForeground(Color.WHITE);
        resetPasswordButton.setBackground(new Color(153, 51, 255));
        resetPasswordButton.setFocusPainted(false);
        resetPasswordButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridx = 1;
        c5.gridy = 4;
        c5.anchor = GridBagConstraints.LINE_END;
        c5.insets = new Insets(10, 0, 0, 0);
        panel.add(resetPasswordButton, c5);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Check username and password.
            User currentUser = null;
            boolean loginSuccessful = false;
            File file = new File(USERS_FILE);
            if (!file.exists()) {
                try {
                    boolean fileCreated = file.createNewFile();
                    if (!fileCreated) {
                        JOptionPane.showMessageDialog(this, "Error creating users file");
                        return;
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error creating users file");
                }
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(",");
                    if (userData[0].equals(username) && userData[1].equals(password)) {
                        loginSuccessful = true;
                        currentUser = new User(userData[0], userData[1], userData[2], userData[3]);
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error reading users file");
            }

            if (loginSuccessful) {
                // Open inventory management window.
                gui = new InventoryManagementGUI();
                gui.setVisible(true);

                // Close login window.
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } else if (e.getSource() == registerButton) {
            RegistrationForm registrationForm = new RegistrationForm();
            registrationForm.setVisible(true);
        } else if (e.getSource() == resetPasswordButton) {
            ResetPasswordForm resetPasswordForm = new ResetPasswordForm();
            resetPasswordForm.setVisible(true);
        }
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public void closeGUI(){
        gui.setVisible(false);
        LoginWindow loginWindow = new LoginWindow();
    }
}
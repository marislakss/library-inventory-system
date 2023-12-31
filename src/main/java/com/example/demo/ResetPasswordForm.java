package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResetPasswordForm extends JFrame {
    // Logger initialization
    private static final Logger LOGGER = Logger.getLogger(ResetPasswordForm.class.getName());

    // UI components.
    private final JTextField usernameField;
    private final JPasswordField oldPasswordField;
    private final JPasswordField newPasswordField;
    private final JTextField securityQuestionField;

    public ResetPasswordForm() {
        // Initialize UI components and set up the layout.
        super("Reset Password");
        LookAndFeelUtil.setLookAndFeel();
        setSize(400, 250);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Add components to the panel and set GridBagConstraints.
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(usernameLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(usernameField, c);

        JLabel oldPasswordLabel = new JLabel("Old Password:");
        oldPasswordField = new JPasswordField(20);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(oldPasswordLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(oldPasswordField, c);

        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordField = new JPasswordField(20);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(newPasswordLabel, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(newPasswordField, c);

        JLabel securityQuestionLabel = new JLabel("Security Question:");
        securityQuestionField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(securityQuestionLabel, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(securityQuestionField, c);

        JButton resetButton = new JButton("Reset Password");
        resetButton.setForeground(Color.WHITE);
        resetButton.setFocusPainted(false);
        resetButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        resetButton.setBackground(new Color(50, 50, 255)); // light blue color
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_END;
        panel.add(resetButton, c);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(panel, c);

        setVisible(true);

        // Set up ActionListener for resetButton.
        resetButton.addActionListener(e -> {
            String username = usernameField.getText();
            String oldPassword = new String(oldPasswordField.getPassword());
            String newPassword = new String(newPasswordField.getPassword());
            String securityQuestion = securityQuestionField.getText();

            // Check if username and old password match.
            boolean userFound = false;
            List<String> updatedLines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length == 7 && fields[0].equals(username) && fields[1].equals(oldPassword) && fields[6].equals(securityQuestion)) {
                        // Update user's password.
                        fields[1] = newPassword;
                        userFound = true;
                    }
                    updatedLines.add(String.join(",", fields));
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(ResetPasswordForm.this, "Error reading user data");
                return;
            }

            if (userFound) {
                // Save updated user data to file.
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt"))) {
                    for (String line : updatedLines) {
                        bw.write(line);
                        bw.newLine();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(ResetPasswordForm.this, "Error updating user data");
                    return;
                }

                JOptionPane.showMessageDialog(ResetPasswordForm.this, "Password reset successful");
                dispose();
            } else {
                LOGGER.log(Level.WARNING, "Incorrect username, old password, or security question");
                JOptionPane.showMessageDialog(ResetPasswordForm.this, "Incorrect username, old password, or security question");
            }
        });
    }
}
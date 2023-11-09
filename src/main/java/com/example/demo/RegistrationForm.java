package com.example.demo;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class RegistrationForm extends JFrame implements ActionListener {

    // Logger declaration
    private static final Logger LOGGER = Logger.getLogger(RegistrationForm.class.getName());

    // Declare form fields and buttons.
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField contactNumberField;
    private final JTextField emailField;
    private final JTextField securityQuestionField;
    private final JButton registerButton;
    private final JButton cancelButton;

    // Declare text file paths.
    private static final String USERS_FILE = "users.txt";

    public RegistrationForm() {
        super("Registration");
        LookAndFeelUtil.setLookAndFeel();
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create main panel.
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Create header panel.
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel headerLabel = new JLabel("Registration Form");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(headerLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Create form panel.
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Username field.
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 0;
        formPanel.add(usernameLabel, c);
        c.gridx = 1;
        formPanel.add(usernameField, c);

        // Password field.
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        c.gridx = 0;
        c.gridy = 1;
        formPanel.add(passwordLabel, c);
        c.gridx = 1;
        formPanel.add(passwordField, c);

        // First name field.
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 2;
        formPanel.add(firstNameLabel, c);
        c.gridx = 1;
        formPanel.add(firstNameField, c);

        // Last name field.
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 3;
        formPanel.add(lastNameLabel, c);
        c.gridx = 1;
        formPanel.add(lastNameField, c);

        // Contact number field.
        JLabel contactNumberLabel = new JLabel("Contact Number:");
        contactNumberField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 4;
        formPanel.add(contactNumberLabel, c);
        c.gridx = 1;
        formPanel.add(contactNumberField, c);

        // Email field.
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 5;
        formPanel.add(emailLabel, c);
        c.gridx = 1;
        formPanel.add(emailField, c);

        // Security question field.
        JLabel securityQuestionLabel = new JLabel("Security Question:");
        securityQuestionField = new JTextField(20);
        c.gridx = 0;
        c.gridy = 6;
        formPanel.add(securityQuestionLabel, c);
        c.gridx = 1;
        formPanel.add(securityQuestionField, c);

        // Register and Cancel buttons.
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = 7;
        formPanel.add(registerButton,c);

        // Cancel button.
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        c.gridx = 1;
        formPanel.add(cancelButton, c);

        // Set visibility.
        setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == registerButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String contactNumber = contactNumberField.getText();
            String email = emailField.getText();
            String securityQuestion = securityQuestionField.getText();

            // Check if username is already taken.
            boolean usernameTaken = checkUsernameTaken(username);

            if (usernameTaken) {
                JOptionPane.showMessageDialog(this, "Username already taken, please choose a different one", "Registration Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Create new user record and save to file.
                createUserRecord(username, password, firstName, lastName, contactNumber, email, securityQuestion);

                // Show success message.
                JOptionPane.showMessageDialog(this, "Registration successful!", "Registration Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear fields.
                usernameField.setText("");
                passwordField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                contactNumberField.setText("");
                emailField.setText("");
                securityQuestionField.setText("");
            }
        }

        else if (e.getSource() == cancelButton) {
            // Clear fields and close window.
            usernameField.setText("");
            passwordField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            contactNumberField.setText("");
            emailField.setText("");
            securityQuestionField.setText("");
            dispose();
        }
    }

    private boolean checkUsernameTaken(String username) {
        // Read user records from file and check if given username matches any of them.
        try {
            File file = new File(USERS_FILE);
            if (!file.exists()) {
                boolean fileCreated = file.createNewFile();
                if(!fileCreated) {
                    LOGGER.log(Level.WARNING, "File could not be created");
                }
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    String storedUsername = fields[0];

                    if (storedUsername.equals(username)) {
                        return true;
                    }
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "An exception occurred", ex);
        }
        return false;
    }

    private void createUserRecord(String username, String password, String firstName, String lastName, String contactNumber, String email, String securityQuestion) {
        // Append new user record to file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            writer.write(username + "," + password + "," + firstName + "," + lastName + "," + contactNumber + "," + email + "," + securityQuestion);
            writer.newLine();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "An exception occurred", ex);
        }
    }

    public static void main(String[] args) {

        // Create and display the RegistrationForm
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setVisible(true);
    }
}
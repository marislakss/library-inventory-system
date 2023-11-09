package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.logging.Level;

public class InventoryManagementGUI extends JFrame {

    // UI components.
    JTextField nameField;
    JTextField priceField;
    JTextField quantityField;
    JTextField removeID;
    JTextField publish;
    JTextField printed;
    JTextField iSBNField;
    JTextField updateName;
    JTextField updatePrice;
    JTextField updateQuantity;
    JTextField updateId;
    JTextField updatePublish;
    JTextField updatePrinted;
    JTextField updateISBN;
    private final JComboBox<String> typeCombo;
    private final JComboBox<String> typeCombo2;
    private final JComboBox<String> typeCombo3;
    private final JTable inventoryTable;
    static LoginWindow loginWindow;

    // Declare constants for genres.
    private static final String FICTION = "Fiction";
    private static final String MYSTERY = "Mystery";
    private static final String HORROR = "Horror";
    private static final String HISTORY = "History";
    private static final String ROMANCE = "Romance";
    private static final String THRILLER = "Thriller";
    private static final String BIOGRAPHY = "Biography";
    private static final String SCIENCE = "Science";
    private static final String CHILDREN = "Children";
    private static final String OTHER = "Other";

    // Declare constants for fonts and colors.
    private static final String ARIAL_FONT = "Arial";
    private static final String COLOR_HEX = "#77C1B1";

    // Declare constants for column names.
    private static final String ID = "ID";
    private static final String NAME = "Name";
    private static final String GENRE = "Genre";
    private static final String PRICE = "Price";
    private static final String PUBLISHED = "Published";
    private static final String PRINTED_DATE = "Printed";
    private static final String ISBN = "ISBN";

    // Declare constants for error and success messages.
    private static final String ERROR_MSG = "Error";
    private static final String SUCCESS_MSG = "Success";

    // Declare Logger object for logging.
    private static final Logger LOGGER = Logger.getLogger(InventoryManagementGUI.class.getName());

    // Inventory list.
    private final transient ArrayList<Book> inventory; // Stores the books.

    public InventoryManagementGUI() {
        UIManager.put("Button.background", UIManager.getColor("control"));
        inventory = new ArrayList<>(); // Initialize inventory list.

        Book book1 = new Book(1,"Book1",FICTION,20.0,2,"11/01/2011","21/02/2011","356890");
        Book book2 = new Book(2,"Book2",MYSTERY,30.0,3,"08/05/2014","26/03/2015","457896");
        Book book3 = new Book(3,"Book3",HORROR,50.0,5,"15/03/2017","21/12/2017","298476");
        Book book4 = new Book(4,"Book4",HISTORY,70.0,3,"22/08/2022","03/11/2023","731369");

        inventory.add(book1);
        inventory.add(book2);
        inventory.add(book3);
        inventory.add(book4);

        // Set up main window.
        setTitle("Library Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create tabs.
        // GUI components.
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font(ARIAL_FONT, Font.PLAIN, 18));

        // Create panels for each tab.
        JPanel addPanel = new JPanel(new GridBagLayout());
        JPanel removePanel = new JPanel(new GridBagLayout());
        JPanel updatePanel = new JPanel(new GridBagLayout());
        JPanel viewPanel = new JPanel(new BorderLayout());
        JPanel logOutPanel = new JPanel(new BorderLayout());

        // Add tabbed pane to main window.
        add(tabbedPane);

        // Add panels to tabs.
        tabbedPane.addTab("Add Book", addPanel);
        tabbedPane.addTab("Remove Book", removePanel);
        tabbedPane.addTab("Update Book", updatePanel);
        tabbedPane.addTab("View Books Inventory", viewPanel);
        tabbedPane.addTab("Search", viewPanel);
        tabbedPane.addTab("View Inventory", viewPanel);
        tabbedPane.addTab("Log Out", logOutPanel);

        /*
            Add items TAB and PANEL
        */

        // Create components for "Add Book" panel.
        JLabel nameLabel = new JLabel("Book Name:");
        JLabel typeLabel = new JLabel("Book Genre:");
        JLabel priceLabel = new JLabel("Price:");
        JLabel quantityLabel = new JLabel("Quantity:");

        nameLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        typeLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        priceLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        quantityLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));

        JLabel MFD = new JLabel("Published:");
        JLabel EXD = new JLabel("Print Date:");
        JLabel iSBN = new JLabel("ISBN:");
        MFD.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        EXD.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        iSBN.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));

        nameField = new JTextField(20);
        priceField = new JTextField(10);
        quantityField = new JTextField(5);
        typeCombo = new JComboBox<>(new String[] {FICTION, MYSTERY, HORROR, ROMANCE, THRILLER, BIOGRAPHY, HISTORY, SCIENCE, CHILDREN, OTHER});
        publish = new JTextField(20);
        printed = new JTextField(20);
        iSBNField = new JTextField(20);

        JButton addButton = new JButton("Add Book");
        addButton.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        addButton.setBackground(Color.decode(COLOR_HEX));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add components to "Add Book" panel.
        addPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        addPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        addPanel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        addPanel.add(typeLabel, gbc);
        gbc.gridx = 1;
        addPanel.add(typeCombo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        addPanel.add(priceLabel, gbc);
        gbc.gridx = 1;
        addPanel.add(priceField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        addPanel.add(quantityLabel, gbc);
        gbc.gridx = 1;
        addPanel.add(quantityField, gbc);

        // Add MFD Label and Field.
        gbc.gridx = 0;
        gbc.gridy = 4;
        addPanel.add(MFD, gbc);
        gbc.gridx = 1;
        addPanel.add(publish, gbc);

        // Add EXD Label and Field.
        gbc.gridx = 0;
        gbc.gridy = 5;
        addPanel.add(EXD, gbc);
        gbc.gridx = 1;
        addPanel.add(printed, gbc);

        // Add ISBN Label and Field.
        gbc.gridx = 0;
        gbc.gridy = 6;
        addPanel.add(iSBN, gbc);
        gbc.gridx = 1;
        addPanel.add(iSBNField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        addPanel.add(addButton, gbc);

        /*
            Remove Items TAB and PANEL
        */

        // Create components for "Remove Book" panel.
        nameLabel = new JLabel("Book ID:");
        nameLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        removeID = new JTextField(20);
        JButton removeButton = new JButton("Remove Book");
        removeButton.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        removeButton.setBackground(Color.decode(COLOR_HEX));
        removeButton.setForeground(Color.WHITE);
        removeButton.setFocusPainted(false);
        removeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add components to "Remove Book" panel.
        removePanel.setBackground(Color.WHITE);
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(10, 10, 10, 10);
        gbc2.anchor = GridBagConstraints.WEST;
        removePanel.add(nameLabel, gbc2);
        gbc2.gridx = 1;
        removePanel.add(removeID, gbc2);
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        gbc2.gridwidth = 2;
        removePanel.add(removeButton, gbc2);

        /*
            Update TAB and PANEL
        */

        // Create components for "Update Book" panel.
        JLabel IDLabel = new JLabel("Book ID:");
        IDLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        nameLabel = new JLabel("Book Name:");
        nameLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));

        typeLabel = new JLabel("Book Genre:");
        typeLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));

        MFD = new JLabel("Published:");
        EXD = new JLabel("Print Date:");
        iSBN = new JLabel("ISBN:");
        MFD.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        EXD.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        iSBN.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));

        updateId = new JTextField(20);
        updateName = new JTextField(20);
        updatePrice = new JTextField(10);
        updateQuantity = new JTextField(5);
        typeCombo2 = new JComboBox<>(new String[] {FICTION, MYSTERY, HORROR, ROMANCE, THRILLER, BIOGRAPHY, HISTORY, SCIENCE, CHILDREN, OTHER});
        updatePublish = new JTextField(20);
        updatePrinted = new JTextField(20);
        updateISBN = new JTextField(20);


        JButton updateButton = new JButton("Update Book");
        updateButton.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        updateButton.setBackground(Color.decode(COLOR_HEX));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        updateButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add components to "Update Book" panel.
        updatePanel.setBackground(Color.WHITE);
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.insets = new Insets(10, 10, 10, 10);
        gbc3.anchor = GridBagConstraints.WEST;
        updatePanel.add(IDLabel, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(updateId, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 1;
        updatePanel.add(nameLabel, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(updateName, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 2;
        updatePanel.add(typeLabel, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(typeCombo2, gbc3);
        gbc3.gridx = 0;
        gbc3.gridy = 3;
        updatePanel.add(priceLabel, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(updatePrice, gbc3);
        gbc3.gridx = 0;
        gbc3.gridy = 4;
        updatePanel.add(quantityLabel, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(updateQuantity, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 5;
        updatePanel.add(MFD, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(updatePublish, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 6;
        updatePanel.add(EXD, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(updatePrinted, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 7;
        updatePanel.add(iSBN, gbc3);
        gbc3.gridx = 1;
        updatePanel.add(updateISBN, gbc3);

        gbc3.gridx = 0;
        gbc3.gridy = 8;
        gbc3.gridwidth = 2;
        updatePanel.add(updateButton, gbc3);

        /*
            ViewInventory TABS and PANEL
        */

        // Create components for "View Inventory" panel.
        JButton viewButton = new JButton("Generate Report");
        viewButton.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        viewButton.setBackground(Color.decode("#247BA0"));


        inventoryTable = new JTable(new InventoryTableModel(inventory));
        JScrollPane scrollPane = new JScrollPane(inventoryTable);

        // Add components to "View Inventory" panel.
        viewPanel.add(scrollPane, BorderLayout.CENTER);
        viewPanel.add(viewButton, BorderLayout.SOUTH);

        // Customize "View Inventory" panel.
        viewPanel.setBackground(Color.WHITE);
        viewPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        /*
            SEARCH TABS and PANEL
        */

        // Create header panel.
        JPanel headerPanel = new JPanel(new BorderLayout());

        // Create search panel.
        JPanel searchPanel = new JPanel(new GridBagLayout());
        typeCombo3 = new JComboBox<>(new String[]{ID, NAME, GENRE, PRICE, PUBLISHED, PRINTED_DATE, ISBN});
        typeCombo3.setFont(new Font(ARIAL_FONT, Font.PLAIN, 18));

        JTextField inputField = new JTextField(20);
        JLabel searchLabel = new JLabel("Search by:");
        searchLabel.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        inputField.setFont(new Font(ARIAL_FONT, Font.PLAIN, 18));
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font(ARIAL_FONT, Font.PLAIN, 18));
        searchButton.setBackground(Color.decode(COLOR_HEX));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add search components to search panel.
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 0;
        gbc5.insets = new Insets(10, 10, 10, 10);
        gbc5.anchor = GridBagConstraints.WEST;
        searchPanel.add(searchLabel, gbc5);
        gbc5.gridx = 1;
        searchPanel.add(inputField, gbc5);
        gbc5.gridx = 2;
        searchPanel.add(typeCombo3,gbc5);
        gbc5.gridx = 3;
        searchPanel.add(searchButton, gbc5);

        // Add search panel to header panel.
        headerPanel.add(searchPanel, BorderLayout.NORTH);

        // Add header panel to main window.
        add(headerPanel, BorderLayout.NORTH);

        // Add panels to tabs.
        tabbedPane.addTab("Search Book", headerPanel);

        // Log out tab and panel.
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(e -> {
            LOGGER.log(Level.INFO, "Login status: {0}", loginWindow.isLoggedIn());
            loginWindow.setLoggedIn(false);
            loginWindow.closeGUI();
        });
        logOutButton.setFont(new Font(ARIAL_FONT, Font.PLAIN, 20));
        logOutButton.setBackground(Color.WHITE);
        logOutButton.setForeground(Color.BLACK);
        logOutButton.setFocusPainted(false);
        logOutButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        logOutPanel.setBackground(Color.WHITE);
        logOutPanel.add(logOutButton, BorderLayout.CENTER);

        // Add tabbed pane to main window.
        add(tabbedPane);

        setVisible(true);

        // --------- Event Listeners for button ------------

        addButton.addActionListener(e -> {
            // Get input values.
            String name = nameField.getText();
            String type = Objects.requireNonNull(typeCombo.getSelectedItem()).toString();
            double price = 0;
            int quantity = 0;
            String priceStr = priceField.getText();
            String quantityStr = quantityField.getText();
            String MFDStr = publish.getText();
            String EXDStr = printed.getText();
            String ISBNStr = iSBNField.getText();

            // Check if fields are empty.
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a name.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
            }

            if (!priceStr.isEmpty()) {
                price = Double.parseDouble(priceStr);
            }
            else {
                JOptionPane.showMessageDialog(null, "Please enter price.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
            }
            if (!quantityStr.isEmpty()) {
                quantity = Integer.parseInt(quantityStr);
            }
            else {
                JOptionPane.showMessageDialog(null, "Please enter quantity.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
            }

            // Create new Book object with a generated ID.
            int id = inventory.size() + 1;
            Book book = new Book(id, name, type, price, quantity,EXDStr, MFDStr, ISBNStr);

            // Add Book to inventory.
            inventory.add(book);

            // Update table.
            inventoryTable.setModel(new InventoryTableModel(inventory));

            // Clear input fields.
            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");
            publish.setText("");
            printed.setText("");
            iSBNField.setText("");

            // Show success message.
            JOptionPane.showMessageDialog(null, "Book added successfully.", SUCCESS_MSG, JOptionPane.INFORMATION_MESSAGE);
        });

        removeButton.addActionListener(e -> {
            // Get Book ID.
            int id = Integer.parseInt(removeID.getText());

            // Find Book with the given ID in inventory.
            int index = -1;
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).getId() == id) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Book not found in inventory.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Remove Book from inventory.
            inventory.remove(index);

            // Clear input field.
            removeID.setText("");

            // Update table.
            inventoryTable.setModel(new InventoryTableModel(inventory));

            // Show success message.
            JOptionPane.showMessageDialog(null, "Book removed successfully.", SUCCESS_MSG, JOptionPane.INFORMATION_MESSAGE);
        });

        updateButton.addActionListener(e -> {
            // Check if any items are present in the inventory.
            if (inventory.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Inventory is empty. Please add books before updating.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get selected row.
            int row = inventoryTable.getSelectedRow();

            // Validate input values.
            String idString = updateId.getText().trim();
            String name = updateName.getText().trim();
            String type = Objects.requireNonNull(typeCombo2.getSelectedItem()).toString();
            String priceString = updatePrice.getText().trim();
            String quantityString = updateQuantity.getText().trim();
            String PUBStr = updatePublish.getText().trim();
            String PRINTStr = updatePrinted.getText().trim();
            String ISBNStr = updateISBN.getText().trim();

            int id;
            try {
                id = Integer.parseInt(idString);
                if (id < 0) {
                    JOptionPane.showMessageDialog(null, "ID cannot be negative.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid ID value.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                return;
            }

            int index = -1;
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).getId() == id) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Book with ID " + id + " Not found in inventory.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (priceString.isEmpty() || quantityString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all fields.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                return;
            }

            double price;
            try {
                price = Double.parseDouble(priceString);
                if (price < 0) {
                    JOptionPane.showMessageDialog(null, "Price cannot be negative.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid price value.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    JOptionPane.showMessageDialog(null, "Quantity cannot be negative.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid quantity value.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update Book object.
            Book book = inventory.get(index);
            book.setName(name);
            book.setGenre(type);
            book.setPrice(price);
            book.setQuantity(quantity);
            book.setPrinted(PUBStr);
            book.setPublish(PRINTStr);
            book.setIsbnNumber(ISBNStr);

            // Clear input fields.
            updateId.setText("");
            updateName.setText("");
            updatePrice.setText("");
            updateQuantity.setText("");
            updatePublish.setText("");
            updatePrinted.setText("");
            updateISBN.setText("");

            // Update table.
            inventoryTable.setModel(new InventoryTableModel(inventory));
            // Show success message.
            JOptionPane.showMessageDialog(null, "Book updated successfully.", SUCCESS_MSG, JOptionPane.INFORMATION_MESSAGE);
        });

        viewButton.addActionListener(e -> {
            // Generate report.
            StringBuilder report = new StringBuilder("Current Inventory Report:\n\n");
            report.append("Book Name\tBook Genre\tPrice\tQuantity\n");
            for (Book book : inventory) {
                report.append(book.getName()).append("\t").append(book.getGenre()).append("\t").append(book.getPrice()).append("\t").append(book.getQuantity()).append("\n");
            }

            // Display report in message dialog.
            JOptionPane.showMessageDialog(null, report.toString());
        });

        searchButton.addActionListener(e -> {
            if (inventory.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Inventory is empty.", ERROR_MSG, JOptionPane.ERROR_MESSAGE);
                return;
            }

            String input = inputField.getText();
            String category = (String) typeCombo3.getSelectedItem();
            ArrayList<Book> searchResults = new ArrayList<>();

            LOGGER.log(Level.INFO, "Input: {0} Category: {1}", new Object[]{input, category});
            // Search for Book matching the input in the selected category.
            for (Book book : inventory) {
                if (Objects.equals(category, ID) && Objects.equals(String.valueOf(book.getId()), input)) {
                    searchResults.add(book);
                } else if (Objects.equals(category, NAME) && Objects.equals(book.getName(), input)) {
                    searchResults.add(book);
                } else if (Objects.equals(category, GENRE) && Objects.equals(book.getGenre(), input)) {
                    searchResults.add(book);
                } else if (Objects.equals(category, PRICE) && Objects.equals(Double.toString(book.getPrice()), input)) {
                    searchResults.add(book);
                } else if (Objects.equals(category, PUBLISHED) && Objects.equals(book.getPrinted(), input)) {
                    searchResults.add(book);
                } else if (Objects.equals(category, PRINTED_DATE) && Objects.equals(book.getPublish(), input)) {
                    searchResults.add(book);
                } else if (Objects.equals(category, ISBN) && Objects.equals(book.getIsbnNumber(), input)) {
                    searchResults.add(book);
                }
            }

            if (searchResults.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No items found.");
                return;
            }

            // Create a table to display the search results.
            String[] columnNames = {ID, NAME, GENRE, PRICE, PUBLISHED, PRINTED_DATE, ISBN};
            Object[][] rowData = new Object[searchResults.size()][7];
            int i = 0;
            for (Book book : searchResults) {
                rowData[i][0] = book.getId();
                rowData[i][1] = book.getName();
                rowData[i][2] = book.getGenre();
                rowData[i][3] = book.getPrice();
                rowData[i][4] = book.getPrinted();
                rowData[i][5] = book.getPublish();
                rowData[i][6] = book.getIsbnNumber();
                i++;
            }

            JTable searchTable = new JTable(rowData, columnNames);
            JScrollPane scrollPane1 = new JScrollPane(searchTable);
            scrollPane1.setPreferredSize(new Dimension(800, 400));
            JOptionPane.showMessageDialog(null, scrollPane1, "Search results", JOptionPane.PLAIN_MESSAGE);
        });
    }

    public static void main(String[] args) {

        // Create login window object.
        loginWindow = new LoginWindow();

        // Show login window
        loginWindow.setVisible(true);
    }
}
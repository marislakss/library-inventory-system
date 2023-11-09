package com.example.demo;

import javax.swing.table.AbstractTableModel;
import java.io.Serializable;
import java.util.List;


// The InventoryTableModel class extends AbstractTableModel to display
// the inventory of books in a JTable.
public class InventoryTableModel extends AbstractTableModel implements Serializable {

    // The list of books that form the table's data.
    private List<Book> inventory;

    // Enum that contains the column names of the table.
    public enum Column {
        ID("ID", 0),
        BOOK_NAME("Book name", 1),
        BOOK_GENRE("Book genre", 2),
        PRICE("Price", 3),
        QUANTITY("Quantity", 4),
        PUBLISHED("Published", 5),
        PRINTED("Printed", 6),
        ISBN("ISBN", 7);

        private final String name;
        private final int index;

        Column(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }
        public int getIndex() {
            return index;
        }
    }

    // Constructor that initializes the inventory with the given list of books.
    public InventoryTableModel(List<Book> inventory) {
        this.inventory = inventory;
    }

    public void setInventory(List<Book> inventory) {
        this.inventory = inventory;
    }

    @Override
    public int getRowCount() {
        return inventory.size();
    }

    @Override
    public int getColumnCount() {
        return Column.values().length;
    }

    @Override
    public String getColumnName(int column) {
        return Column.values()[column].getName();
    }

    // Returns the value at the specified row and column index in the table.
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = inventory.get(rowIndex);

        // Return the corresponding attribute value for each column index.
        Column column = Column.values()[columnIndex];
        return switch (column) {
            case ID -> book.getId();
            case BOOK_NAME -> book.getName();
            case BOOK_GENRE -> book.getGenre();
            case PRICE -> book.getPrice();
            case QUANTITY -> book.getQuantity();
            case PUBLISHED -> book.getPrinted();
            case PRINTED -> book.getPublish();
            case ISBN -> book.getIsbnNumber();
        };
    }

    // Sets the value at the specified row and column index in the table.
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Book book = inventory.get(rowIndex);
        Column column = Column.values()[columnIndex];
        switch (column) {
            case ID -> book.setId((int) value);
            case BOOK_NAME -> book.setName((String) value);
            case BOOK_GENRE -> book.setGenre((String) value);
            case PRICE -> book.setPrice((double) value);
            case QUANTITY -> book.setQuantity((int) value);
            case PUBLISHED -> book.setPrinted((String) value);
            case PRINTED -> book.setPublish((String) value);
            case ISBN -> book.setIsbnNumber((String) value);
        }

        // Notify the table that the cell has been updated.
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    // Specifies that all cells in the table are editable.
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
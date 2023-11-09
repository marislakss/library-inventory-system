package com.example.demo;
import java.io.Serializable;

// The Book class represents a book object with its properties and associated methods.
public class Book implements Serializable {

    // Declare properties of the Book class.
    private int id;
    private String name;
    private String genre;
    private double price;
    private int quantity;
    private String publish;
    private String printed;
    private String isbnNumber;

    // Constructor for initializing Book objects.
    public Book(int id, String name, String genre, double price, int quantity, String publish, String printed, String isbnNumber) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.quantity = quantity;
        this.publish = publish;
        this.printed = printed;
        this.isbnNumber = isbnNumber;
    }

    // Getter and setter methods for each property of the Book class.
    public int getId() {
        return id;
    }

    public void setId(int ID){
        this.id=ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getPrinted() {
        return printed;
    }

    public void setPrinted(String printed) {
        this.printed = printed;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }
}
package com.example.demo;

public class User {

    // Instance variables.
    private final String username;
    private String password;
    private final String securityQuestion;
    private final String securityAnswer;

    // Constructor.
    public User(String username, String password, String securityQuestion, String securityAnswer) {
        // Assign values to instance variables.
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    // Getter and setter methods.
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }
}

/*
    Getter and setter methods in Java are a programming convention used to provide access to
    an object's private instance variables. They are part of the encapsulation principle in
    object-oriented programming, which promotes the idea of hiding an object's internal state
    and exposing only what is necessary.
*/
package com.example.demo;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// The LookAndFeelUtil class contains utility methods for configuring the LookAndFeel of the application.
public class LookAndFeelUtil {
    private static final Logger LOGGER = Logger.getLogger(LookAndFeelUtil.class.getName());

    // Private constructor to prevent instantiation
    private LookAndFeelUtil() {
        throw new IllegalStateException("Utility class");
    }

    // Sets the application LookAndFeel to Nimbus, if available.
    public static void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.SEVERE, "Error setting LookAndFeel: ", ex);
        }
    }
}
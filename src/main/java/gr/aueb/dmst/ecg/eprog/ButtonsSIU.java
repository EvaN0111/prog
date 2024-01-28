package gr.aueb.dmst.ecg.eprog;

import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class ButtonsSIU {
    public int bt() {
        int a11 = 0;

        // show option panel with buttons
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Running in a headless environment. Unable to create GUI.");
            // Handle headless environment (e.g., log a warning, use a different approach)
        } else {
            int ans = JOptionPane.showOptionDialog(null,
                    "Do you want to Sign In or Sign Up?",
                    "Sign In/Sign Up",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[] { "Sign In", "Sign Up" },
                    "Sign In");

            // actions in case user chooses to Sign-In
            if (ans == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Let's Sign In!");
                a11 = 1;

                // actions in case user chooses to Sign-Up
            } else if (ans == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Let's Sign Up!");
                a11 = 2;

                // actions in case user closes the dialog
            } else if (ans == JOptionPane.CLOSED_OPTION) {
                System.out.println("Dialog closed");
                a11 = 3;
                // Handle dialog closed logic here

            }
        }
        return a11;
    }

}
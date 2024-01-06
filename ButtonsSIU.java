package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;

public class ButtonsSIU {
    public int bt() {
        int a11 = 0;
        int ans = JOptionPane.showOptionDialog(null,
        "Do you want to Sign In or Sign Up?",
        "Sign In/Sign Up",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        new Object[]{"Sign In", "Sign Up"},
        "Sign In");

        if (ans == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Let's Sign In!");
            a11 = 1;
            // Handle Sign In logic here
        } else if (ans == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Let's Sign Up!");
            a11 = 2;
            // Handle Sign Up logic here
        } else if (ans == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed");
            // Handle dialog closed logic here
            
        }
        return a11;
    }

}

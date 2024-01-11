package gr.aueb.dmst.ecg.eprog;

import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class SUfn {

    public static String sif() {

        String fn;
        try {
            do {
                fn = JOptionPane.showInputDialog("Enter your Full name:");
                // insert the user's Fullname.
            } while (fn.equals(""));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been a problem inserting your Fullname");
            fn = " ";
        }

        return fn;
    }

    public static String sip() {
        String ps;
        try {
            ps = JOptionPane.showInputDialog("Enter your Password:");
            // insert the user's password.
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There has been a problem inserting your Password");
            ps = " ";
        }
        return ps;
    }

}
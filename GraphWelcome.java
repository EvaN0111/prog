package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GraphWelcome {

    public String unpanel() {
        // Create a custom panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add an icon
        ImageIcon noteIcon = createImageIcon("C:\\ASOEE\\3o Examino\\java\\ergasia\\note2.png");
        JLabel iconLabel = new JLabel(noteIcon);

        // Add a label with custom color
        JLabel label = new JLabel("Enter your Username:");
        label.setForeground(Color.BLACK);

        // Add a text field
    

        // Add components to the panel
        panel.add(iconLabel);
        panel.add(label);

        // Show the input dialog
        String username = JOptionPane.showInputDialog(
                null,
                panel,
                "MusiVerse",
                JOptionPane.PLAIN_MESSAGE
        );

        if (username != null) {
            // User clicked OK, and the entered username is not null
        } else {
            // User closed the dialog or pressed Cancel
            System.out.println("Dialog closed or Cancel pressed.");
        }
        return username;
    }

    public String pspanel() {
        // Create a custom panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add an icon
        ImageIcon noteIcon = createImageIcon("C:\\ASOEE\\3o Examino\\java\\ergasia\\note2.png");
        JLabel iconLabel = new JLabel(noteIcon);

        // Add a label with custom color
        JLabel label = new JLabel("Enter your Password:");
        label.setForeground(Color.BLACK);

        // Add a text field
    

        // Add components to the panel
        panel.add(iconLabel);
        panel.add(label);

        // Show the input dialog
        String password = JOptionPane.showInputDialog(
                null,
                panel,
                "MusiVerse",
                JOptionPane.PLAIN_MESSAGE
        );

        if (password != null) {
            // User clicked OK, and the entered password is not null
        } else {
            // User closed the dialog or pressed Cancel
            System.out.println("Dialog closed or Cancel pressed.");
        }
        return password;
    }


    public String fnpanel() {
        // Create a custom panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add an icon
        ImageIcon noteIcon = createImageIcon("C:\\ASOEE\\3o Examino\\java\\ergasia\\note2.png");
        JLabel iconLabel = new JLabel(noteIcon);

        // Add a label with custom color
        JLabel label = new JLabel("Enter your Full Name:");
        label.setForeground(Color.BLACK);

        // Add a text field
    

        // Add components to the panel
        panel.add(iconLabel);
        panel.add(label);

        // Show the input dialog
        String fullname = JOptionPane.showInputDialog(
                null,
                panel,
                "MusiVerse",
                JOptionPane.PLAIN_MESSAGE
        );

        if (fullname != null) {
            // User clicked OK, and the entered fullname is not null
        } else {
            // User closed the dialog or pressed Cancel
            System.out.println("Dialog closed or Cancel pressed.");
        }
        return fullname;
    }

    private static ImageIcon createImageIcon(String path) {
        try {
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

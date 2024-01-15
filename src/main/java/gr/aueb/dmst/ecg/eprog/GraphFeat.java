package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class GraphFeat extends JFrame {

    private JPanel featPanel;
    private CountDownLatch latch = new CountDownLatch(1);
    private int ch = 0;

    // create the panel where the user will be choosing what feature they would like to use.
    public GraphFeat() {
        setTitle("Choose a feature!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        featPanel = new StarPanel();
        featPanel.setLayout(new BoxLayout(featPanel, BoxLayout.Y_AXIS));
        featPanel.setBackground(new Color(0, 0, 102));
        addText(featPanel, "Would you like to:");
        addButtons();

        // center the frame on the screen
        setLocationRelativeTo(null);
        
        // display the JFrame
        setVisible(true);

        // wait for user interaction
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addText(JPanel panel, String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Impact", Font.ITALIC, 16));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.WHITE);
        panel.add(label);
    }

    private void addButtons() {
        
        // create buttons
        JButton psButton = createButton("Get a new playlist suggestion.");
        JButton gsButton = createButton("View your Genre Statistics.");
        JButton phButton = createButton("View your recent Playlist History.");
        JButton soButton = createButton("Sign out.");

        // add action listeners to the buttons
        psButton.addActionListener(createActionListener("Get a new playlist suggestion."));
        gsButton.addActionListener(createActionListener("View your Genre Statistics."));
        phButton.addActionListener(createActionListener("View your recent Playlist History."));
        soButton.addActionListener(createActionListener("Sign out."));

        // set alignment for buttons
        psButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        gsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        phButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        soButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        featPanel.add(Box.createVerticalStrut(15)); // add some vertical spacing
        featPanel.add(psButton);
        featPanel.add(Box.createVerticalStrut(15)); // add some vertical spacing
        featPanel.add(gsButton);
        featPanel.add(Box.createVerticalStrut(15)); // add some vertical spacing
        featPanel.add(phButton);
        featPanel.add(Box.createVerticalStrut(15)); // add some vertical spacing
        featPanel.add(soButton);

        add(featPanel);
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(Color.WHITE); // set background color
        button.setForeground(Color.BLACK); // set text color
        button.setFocusPainted(false); // remove focus border
        button.setFont(new Font("Impact", Font.ITALIC, 16)); // set font
        return button;
    }


    private ActionListener createActionListener(final String txt) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChSelected(txt);
            }
        };
    }

    private void handleChSelected(String txt) {
        if (txt.equalsIgnoreCase("Get a new playlist suggestion.")) {
            ch = 1;
        } else if (txt.equalsIgnoreCase("View your Genre Statistics.")) {
            ch = 2;
        } else if (txt.equalsIgnoreCase("View your recent Playlist History.")) {
            ch = 3;
        } else if (txt.equalsIgnoreCase("Sign out.")) {
            ch = 4;
        }
        latch.countDown();
        dispose();
    }

    public int getChoice() {
        return ch;
    }
}

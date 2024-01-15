package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class GraphNP extends JFrame {
    
    private JPanel npPanel;
    private CountDownLatch latch = new CountDownLatch(1);
    private String ans;
    
    // create the panel where the user will be choosing whether they want another playlist or not 
    public GraphNP() {
        // set up the JFrame
        
        setTitle("Choose a new playlist!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        npPanel = new StarPanel();
        npPanel.setLayout(new BoxLayout(npPanel, BoxLayout.Y_AXIS));
        npPanel.setBackground(new Color(0, 0, 102));
        addQuestion(npPanel, "Would you like a new playlist?");
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

    private void addQuestion(JPanel panel, String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Impact", Font.ITALIC, 16));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setForeground(Color.WHITE);
        panel.add(label);
    }

    private void addButtons() {
        
        // create buttons
        JButton yesButton = createButton("Yes");
        JButton noButton = createButton("No");

        // add action listeners to the buttons
        yesButton.addActionListener(createActionListener("Yes"));
        noButton.addActionListener(createActionListener("No"));

        // set alignment for buttons
        yesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        noButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        npPanel.add(Box.createVerticalStrut(10)); // add some vertical spacing
        npPanel.add(yesButton);
        npPanel.add(Box.createVerticalStrut(10)); // add some vertical spacing
        npPanel.add(noButton);

        add(npPanel);
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(Color.WHITE); // set background color
        button.setForeground(Color.BLACK); // set text color
        button.setFocusPainted(false); // remove focus border
        button.setFont(new Font("Impact", Font.ITALIC, 16)); // set font
        return button;
    }

    private ActionListener createActionListener(final String np) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNpSelected(np);
            }
        };
    }

    public void handleNpSelected(String np) {
        if (np.equalsIgnoreCase("Yes")) {
            ans = "Yes";
        } else if (np.equalsIgnoreCase("No")) {
            ans = "No";
        }
        latch.countDown();
        dispose();
        
    }
    public String getAns() {
        return ans;
    }
}

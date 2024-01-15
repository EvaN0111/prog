package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;

public class LogInPanel extends JPanel {

    private JLabel welcomeLabel;
    private Timer timer;

    public LogInPanel(JFrame frame) {
        setBackground(new Color(0, 0, 102)); // dark blue backround (RGB: 0, 0, 102)

        // create JLabel for log in  message
        welcomeLabel = new JLabel("You have succesfully logged in, enjoy!");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Edwardian Script ITC", Font.BOLD, 40)); 

        // create a GridBagLayout
        setLayout(new GridBagLayout());

        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;

        
        add(welcomeLabel, gbc);

        // create a Timer that will close the panel after 3.5 seconds
        timer = new Timer(3500, e -> {
            frame.dispose(); 
            timer.stop(); 
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // add stars
        drawStars(g, 100);
    }

    private void drawStars(Graphics g, int numStars) {
        if (g != null) {
            g.setColor(Color.YELLOW);
            for (int i = 0; i < numStars; i++) {
                int x = (int) (Math.random() * getWidth());
                int y = (int) (Math.random() * getHeight());
                g.fillRect(x, y, 2, 2);
            }
        }
    }
}

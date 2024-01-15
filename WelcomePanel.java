package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class WelcomePanel extends JPanel {

    private JLabel welcomeLabel;
    private Timer timer;
    private float panelAlpha;

    //create the welcome panel
    public WelcomePanel(JFrame frame) {
        setBackground(new Color(0, 0, 102));
        setBorder(new EmptyBorder(20, 20, 20, 20));

       //create a Jlabel for the message
        welcomeLabel = new JLabel("Welcome to MusiVerse!");
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

        // add the JLabel 
        add(welcomeLabel, gbc);

        // create a timer for the dicrease of the transparency
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelAlpha < 1.0f) {
                    panelAlpha += 0.02f; // dicrease the transparency
                    setAlpha(panelAlpha);
                    repaint();
                } else {
                    timer.stop();
                }
            }
        });
        timer.start();

        // create a timer that closes the panel after 4 seconds
        Timer closeTimer;
        closeTimer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // close the frame
            }
        });
        closeTimer.start();
    }

    private void setAlpha(float alpha) {
        // checks if alpha value is valid
        alpha = Math.min(1.0f, Math.max(0.0f, alpha));
    
        // sets the transparency
        if (getBackground() instanceof Color) {
            Color bgColor = (Color) getBackground();
            setBackground(new Color(bgColor.getRed(), bgColor.getGreen(), bgColor.getBlue(), (int) (alpha * 255)));
        }
        if (welcomeLabel.getForeground() instanceof Color) {
            Color fgColor = welcomeLabel.getForeground();
            welcomeLabel.setForeground(new Color(fgColor.getRed(), fgColor.getGreen(), fgColor.getBlue(), (int) (alpha * 255)));
        }
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

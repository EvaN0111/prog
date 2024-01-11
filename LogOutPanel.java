package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class LogOutPanel extends JPanel {

    private JLabel welcomeLabel;
    private Timer timer;
    private float alpha = 0.9f;

    public LogOutPanel(JFrame frame) {
        setBackground(new Color(0, 0, 102));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        welcomeLabel = new JLabel("Thank you, see you soon...");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Edwardian Script ITC", Font.BOLD, 40));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(welcomeLabel, gbc);

        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (alpha > 0.02f) {
                    alpha -= 0.02f;
                    repaint();
                } else {
                    timer.stop();
                    frame.dispose();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        drawStars(g2d, 100);

        g2d.dispose();
    }

    private void drawStars(Graphics2D g, int numStars) {
        if (g != null) {
            g.setColor(Color.YELLOW);
            for (int i = 0; i < numStars; i++) {
                int x = (int) (Math.random() * getWidth());
                int y = (int) (Math.random() * getHeight());
                g.fillRect(x, y, 2, 2);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MusiVerse App");
            frame.setUndecorated(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LogOutPanel welcomePanel = new LogOutPanel(frame);
            frame.add(welcomePanel);

            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

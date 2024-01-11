package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;

public class LogInPanel extends JPanel {

    private JLabel welcomeLabel;
    private Timer timer;

    public LogInPanel(JFrame frame) {
        setBackground(new Color(0, 0, 102)); // Μπλε σκούρο φόντο (RGB: 0, 0, 102)

        // Δημιουργία ενός JLabel για το μήνυμα καλωσορίσματος
        welcomeLabel = new JLabel("You have succesfully logged in, enjoy!");
        welcomeLabel.setForeground(Color.WHITE); // Λευκό χρώμα κειμένου
        welcomeLabel.setFont(new Font("Edwardian Script ITC", Font.BOLD, 40)); // Ρυθμίσεις γραμματοσειράς 

        // Δημιουργία ενός GridBagLayout
        setLayout(new GridBagLayout());

        // Καθορισμός του GridBagConstraints για τον κεντρικό τοπικό προσανατολισμό
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Προσθήκη του JLabel στο πάνελ με τις ρυθμίσεις του GridBagConstraints
        add(welcomeLabel, gbc);

        // Δημιουργία Timer που θα κλείσει το παράθυρο μετά από 5 δευτερόλεπτα
        timer = new Timer(5000, e -> {
            frame.dispose(); // Κλείνει το παράθυρο
            timer.stop(); // Σταματά τον Timer μετά από την πρώτη εκτέλεση
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Προσθήκη αστεριών
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MusiVerse App");
            frame.setUndecorated(true); // Αφαιρεί την πλαίσιο διακόσμησης
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            LogInPanel welcomePanel = new LogInPanel(frame);
            frame.add(welcomePanel);

            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

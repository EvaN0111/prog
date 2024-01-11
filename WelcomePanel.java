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

    public WelcomePanel(JFrame frame) {
        setBackground(new Color(0, 0, 102)); // Μπλε σκούρο φόντο (RGB: 0, 0, 102)
        setBorder(new EmptyBorder(20, 20, 20, 20)); // Προσθήκη ανθυγειού

        // Δημιουργία ενός JLabel για το μήνυμα καλωσορίσματος
        welcomeLabel = new JLabel("Welcome to MusiVerse!");
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

        // Δημιουργία Timer για τη μετάβαση
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelAlpha < 1.0f) {
                    panelAlpha += 0.02f; // Αυξάνει τη διαφάνεια
                    setAlpha(panelAlpha);
                    repaint();
                } else {
                    timer.stop(); // Σταματάει τον Timer μόλις η διαφάνεια γίνει 1
                }
            }
        });
        timer.start();

        // Δημιουργία Timer που θα κλείσει το παράθυρο μετά από 5 δευτερόλεπτα
        Timer closeTimer;
        closeTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Κλείνει το παράθυρο
            }
        });
        closeTimer.start();
    }

    private void setAlpha(float alpha) {
        // Ελέγχει αν η τιμή του alpha είναι στο έγκυρο εύρος
        alpha = Math.min(1.0f, Math.max(0.0f, alpha));
    
        // Ρυθμίζει τη διαφάνεια του πανελ
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

            WelcomePanel welcomePanel = new WelcomePanel(frame);
            frame.add(welcomePanel);

            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

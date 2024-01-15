package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Queue;

public class History extends JPanel {

    private JLabel welcomeLabel;
    private JButton button1;
    private JLabel messageLabel;
    private JLabel messageLabel2;

    public void history2(JFrame frame, Map<String, Integer> genreCount, Queue<String> queue, boolean[] waits) {
        setBackground(new Color(0, 0, 102));

        // create a  JLabel for the message
        welcomeLabel = new JLabel("Here is your genre history");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Edwardian Script ITC", Font.BOLD, 30));

        // create a button
        button1 = new JButton("Back to Menu");

        messageLabel = new JLabel("Genre Count: " + genreCount);
        messageLabel.setFont(new Font("ITALIC", Font.BOLD, 18));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setMaximumSize(new Dimension(750, Short.MAX_VALUE));

        messageLabel2 = new JLabel("Last heard: " + queue );
        messageLabel2.setFont(new Font("ITALIC", Font.BOLD, 18));
        messageLabel2.setForeground(Color.WHITE);
        messageLabel2.setMaximumSize(new Dimension(750, Short.MAX_VALUE));


        // create a  GridBagLayout
        setLayout(new GridBagLayout());

        //declaration of GridBagConstraints for the JLabel  (welcomeLabel)
        GridBagConstraints gbcWelcome = new GridBagConstraints();
        gbcWelcome.gridx = 0;
        gbcWelcome.gridy = 0;
        gbcWelcome.weightx = 1.0;
        gbcWelcome.anchor = GridBagConstraints.NORTH; // Αλλαγή του αγκυρώματος στον βορρά

        // add the Jlabel
        add(welcomeLabel, gbcWelcome);

        //declaration of GridBagConstraints for the button
        GridBagConstraints gbcButton1 = new GridBagConstraints();
        gbcButton1.gridx = 0; 
        gbcButton1.gridy = 1; 
        gbcButton1.anchor = GridBagConstraints.SOUTHWEST; 

        
       
        button1.setBackground(Color.WHITE);
        button1.setForeground(new Color(0, 0, 102)); //set text color to black
    
        
        GridBagConstraints gbcMessage = new GridBagConstraints();
        gbcMessage.gridx = 0; 
        gbcMessage.gridy = 2; 
        gbcMessage.weighty = 1.0; 
        gbcMessage.anchor = GridBagConstraints.CENTER; 

        GridBagConstraints gbcMessage2 = new GridBagConstraints();
        gbcMessage2.gridx = 0; 
        gbcMessage2.gridy = 3; 
        gbcMessage2.weighty = 1.0; 
        gbcMessage2.anchor = GridBagConstraints.CENTER;

        // add the elements with the GridBagConstraints settings
        add(button1, gbcButton1);
        add(messageLabel, gbcMessage);
        add(messageLabel2, gbcMessage2);


        // add ActionListener
        button1.addActionListener(e -> {
            frame.dispose();  // close the panel when the button is pressed
            waits[0] = true;

        });

       
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawStars(g, 100);
    }

    private void drawStars(Graphics g, int numStars) {
        if (g != null) {
            g.setColor(Color.WHITE);
            for (int i = 0; i < numStars; i++) {
                int x = (int) (Math.random() * getWidth());
                int y = (int) (Math.random() * getHeight());
                g.fillRect(x, y, 2, 2);
            }
        }
    }

}


package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class Showlist extends JPanel {
    private CountDownLatch latch = new CountDownLatch(1);
    private int ch = 0;
    private JLabel welcomeLabel;
    private JButton button1;
    private JLabel messageLabel;

    public Showlist(JFrame frame, String[] p, boolean[] waits) {
        setBackground(new Color(0, 0, 102));

        // create a  JLabel for the message
        welcomeLabel = new JLabel("Here is your playlist");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setFont(new Font("Edwardian Script ITC", Font.BOLD, 30));

        // create a button
        button1 = new JButton("Back to Menu");

        //create and format a label for the message
        StringBuilder labelText = new StringBuilder("<html>");
        for (String element : p) {
            labelText.append(element).append("<br>");
        }
        labelText.append("</html>");

        messageLabel = new JLabel(labelText.toString());
        messageLabel.setFont(new Font("ITALIC", Font.ITALIC, 18));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setMaximumSize(new Dimension(750, Short.MAX_VALUE));

        // create a  GridBagLayout
        setLayout(new GridBagLayout());

        
        GridBagConstraints gbcWelcome = new GridBagConstraints();
        gbcWelcome.gridx = 0;
        gbcWelcome.gridy = 0;
        gbcWelcome.weightx = 1.0;
        gbcWelcome.anchor = GridBagConstraints.NORTH; 

        add(welcomeLabel, gbcWelcome);

        
        GridBagConstraints gbcButton1 = new GridBagConstraints();
        gbcButton1.gridx = 0; 
        gbcButton1.gridy = 1; 
        gbcButton1.anchor = GridBagConstraints.SOUTHWEST;

        

        button1.setBackground(Color.WHITE);
        button1.setForeground(new Color(0, 0, 102));

        
        GridBagConstraints gbcMessage = new GridBagConstraints();
        gbcMessage.gridx = 0; 
        gbcMessage.gridy = 2; 
        gbcMessage.weighty = 1.0; 
        gbcMessage.anchor = GridBagConstraints.CENTER;

        
        add(button1, gbcButton1);
        add(messageLabel, gbcMessage);

        //add ActionListener for the button

        button1.addActionListener(createActionListener("Back to Menu"));
        button1.addActionListener(e -> {
            frame.dispose(); // close the panel when the button is pressed
            waits[0] = true;

        });

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
        if (txt.equalsIgnoreCase("Back to Menu")) {
            ch = 1;
        }
        latch.countDown();
    }

    public int getChoice() {
        return ch;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawStars(g, 100);
    }

    //add stars 
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

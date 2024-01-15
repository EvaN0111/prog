package gr.aueb.dmst.ecg.eprog;

import javax.swing.*;
import java.awt.*;

public class StarPanel extends JPanel {
    // create the appropriate methods so that stars are shown in the backround
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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

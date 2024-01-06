package gr.aueb.dmst.ecg.eprog;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class GraphGoodbye extends JComponent{
    public GraphGoodbye() {
            super();
        }
    
        @Override public void paint(Graphics g) {
            g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 30));
            g.setColor(Color.BLACK);
            g.drawString("You have logged out of", 43, 80);
            g.setColor(Color.BLUE);
            g.drawString("MusiVerse...", 115, 115);
            g.setColor(Color.BLACK);
            g.drawString("Goodbye!", 145, 150);

        }
}

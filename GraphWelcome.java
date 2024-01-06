package gr.aueb.dmst.ecg.eprog;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;


public class GraphWelcome extends JComponent {
        public GraphWelcome() {
            super();
        }
    
        @Override public void paint(Graphics g) {
            g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 30));
            g.setColor(Color.BLACK);
            g.drawString("Welcome to", 100, 80);
            g.setColor(Color.BLUE);
            g.drawString("MusiVerse!", 120, 115);

            

        }

    }





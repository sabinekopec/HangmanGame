package games.hangman;

import java.awt.Graphics;

//import javax.swing.JFrame;
import javax.swing.JPanel;

class GPanel extends JPanel {
	private int count;

	
    public GPanel() {
 //       f.setSize(new Dimension(240, 240));
    }


    public int setRemainingTriesGPanel(int val) {
    	return this.count = val;
    }
    
	@Override
    public void paintComponent(Graphics g) {
//		g.drawRect(0, 0, 240, 240);
		super.paintComponent(g);
//	    Graphics2D g2d = (Graphics2D)g;
//	    g2d.setStroke(new BasicStroke(2));
	    
        switch (count) {
        case 0:
        	//rectangle originates at 10,10 and ends at 240,240
        	g.drawRect(0, 0, 240, 240);
        	break;
        case 1:
        	//rectangle originates at 10,10 and ends at 240,240
        	g.drawRect(0, 0, 240, 240);
        	// half circle symbolizing the ground
            g.drawArc(0, 200, 240, 80, 0, 180);
            break;
        case 2:
        	//rectangle originates at 10,10 and ends at 240,240
        	g.drawRect(0, 0, 240, 240);
        	//circle symbolizing the ground
            g.drawArc(0, 200, 240, 80, 0, 180);
            // first vertical beam
            g.drawLine(60, 205, 60, 50);
            break;
        case 3:
        	//rectangle originates at 10,10 and ends at 240,240
        	g.drawRect(0, 0, 240, 240);
        	// half circle symbolizing the ground
            g.drawArc(0, 200, 240, 80, 0, 180);
            // first vertical beam
            g.drawLine(60, 205, 60, 50);
            // horizontal beam
            g.drawLine(60, 50, 180, 50);
            // stabilizing beam
            g.drawLine(60, 90, 100, 50);
            break;
        case 4:
        	//rectangle originates at 10,10 and ends at 240,240
        	g.drawRect(0, 0, 240, 240);
        	// half circle symbolizing the ground
            g.drawArc(0, 200, 240, 80, 0, 180);
            // first vertical beam
            g.drawLine(60, 205, 60, 50);
            // horizontal beam
            g.drawLine(60, 50, 180, 50);
            // stabilizing beam
            g.drawLine(60, 90, 100, 50);
            // rope
            g.drawLine(180, 50, 180, 80);
            // hangman head
            g.drawArc(170, 80, 20, 20, 0, 360);
            g.fillOval(175, 87, 3, 3);
            g.fillOval(185, 87, 3, 3);
            g.drawArc(175, 93, 10, 5, 0, 180);
            break;
        case 5:
        	//rectangle originates at 10,10 and ends at 240,240
        	g.drawRect(0, 0, 240, 240);
        	// half circle symbolizing the ground
            g.drawArc(0, 200, 240, 80, 0, 180);
            // first vertical beam
            g.drawLine(60, 205, 60, 50);
            // horizontal beam
            g.drawLine(60, 50, 180, 50);
            // stabilizing beam
            g.drawLine(60, 90, 100, 50);
            // rope
            g.drawLine(180, 50, 180, 80);
            // hangman head
            g.drawOval(170, 80, 20, 20);
            g.fillOval(175, 87, 3, 3);
            g.fillOval(185, 87, 3, 3);
            g.drawArc(175, 93, 10, 5, 0, 180);
            // hangman body
            g.drawLine(180, 100, 180, 160);
            break;
        case 6:
        	//rectangle originates at 10,10 and ends at 240,240
        	g.drawRect(0, 0, 240, 240);
        	//half circle symbolizing the ground
            g.drawArc(0, 200, 240, 80, 0, 180);
            // first vertical beam
            g.drawLine(60, 205, 60, 50);
            // horizontal beam
            g.drawLine(60, 50, 180, 50);
            // stabilizing beam
            g.drawLine(60, 90, 100, 50);
            // rope
            g.drawLine(180, 50, 180, 80);
            // hangman head
            g.drawOval(170, 80, 20, 20);
            g.fillOval(175, 87, 3, 3);
            g.fillOval(185, 87, 3, 3);
            g.drawArc(175, 93, 10, 5, 0, 180);
            // hangman body
            g.drawLine(180, 100, 180, 160);
            // hangman arms
            g.drawLine(180, 120, 200, 130);
            g.drawLine(180, 120, 160, 130);
            break;
        case 7:
        	//rectangle originates at 10,10 and ends at 240,240
        	g.drawRect(0, 0, 240, 240);
        	// half circle symbolizing the ground
            g.drawArc(0, 200, 240, 80, 0, 180);
            // first vertical beam
            g.drawLine(60, 205, 60, 50);
            // horizontal beam
            g.drawLine(60, 50, 180, 50);
            // stabilizing beam
            g.drawLine(60, 90, 100, 50);
            // rope
            g.drawLine(180, 50, 180, 80);
            // hangman head
            g.drawOval(170, 80, 20, 20);
            g.fillOval(175, 87, 3, 3);
            g.fillOval(185, 87, 3, 3);
            g.drawArc(175, 93, 10, 5, 0, 180);
            // hangman body
            g.drawLine(180, 100, 180, 160);
            // hangman arms
            g.drawLine(180, 120, 200, 130);
            g.drawLine(180, 120, 160, 130);
            // hangman legs
            g.drawLine(180, 160, 200, 180);
            g.drawLine(180, 160, 160, 180);
            break;
        default:
        	break;
        }
 
    }
}

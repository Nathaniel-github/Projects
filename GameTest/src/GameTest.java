import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class GameTest extends JFrame implements KeyListener {
	
	Foot myFoot;
	
    public GameTest() {
    	 super();
    	 Image foot = (new ImageIcon("leftshoe.gif")).getImage();
    	 myFoot = new Foot(10, 370, foot); 
         JPanel p = new JPanel();
         add(p);
         addKeyListener(this);
         setSize(1400, 800);
         setVisible(true);

    }

    public void paint(Graphics g)
    {
    	g.clearRect(0, 0, 1400, 800);
    	setBackground(Color.WHITE);
    	myFoot.draw(g);
    }

    
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {

    	 if (e.getKeyCode() == KeyEvent.VK_D) {
         	myFoot.moveForward(20);
         }
         if (e.getKeyCode() == KeyEvent.VK_A) {
             myFoot.moveForward(-20);
         }
         if (e.getKeyCode() == KeyEvent.VK_W) {
          	myFoot.moveSideways(-20);
          }
          if (e.getKeyCode() == KeyEvent.VK_S) {
              myFoot.moveSideways(20);
          }
         repaint();
    }

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new GameTest();
    }
}
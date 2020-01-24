import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
/*
 * Author: Nathaniel Thomas
 * Date: 10/18/19
 * Rev: 01
 */
public class WalkerTest extends JPanel
{
  private Image leftshoe, rightshoe;
  private Walker Walker;
  private int x;
  private int y;
  //Fields
  
  
  // Constructor
  public WalkerTest()
  {
    leftshoe =  new ImageIcon("leftshoe.png").getImage(); //Takes image that I have in the program
    rightshoe = new ImageIcon("rightshoe.png").getImage(); //Takes image that I have in the program
    
    x = -400;
    y = 0;
    
    Walker = new Walker(x, y, leftshoe, rightshoe); //Brings Walker to life with the coordinates assigned to it

  }

  // Called automatically when the panel needs repainting
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    for (int count = 1; count <= 4; count++) //Draws the first walker
    {
      Walker.draw(g);
      Walker.nextStep();
      Walker.stop();
    }
    
    for (int count = 1; count <= 4; count++) //Draws the first walker
    {
      Walker.backStep();
      Walker.backStep();
    }
    Walker.downStep();
    for (int i = 1; i <= 3; i ++) { //Draws the second walker
    	Walker.draw(g);
    	if (i == 2) {
    		for (int count = 0; count < 2; count++) {
    			Walker.nextStep();
    			Walker.stop();
    		}
    	}
    	else {
    		Walker.nextStep();
    		Walker.stop();
    	}
    }
  }

  public static void main(String[] args)
  { //Draws the walker in the window
    JFrame window = new JFrame("Feet");
    window.setBounds(100, 100, 500, 480);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    WalkerTest panel = new WalkerTest();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
}
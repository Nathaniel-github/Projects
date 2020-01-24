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
public class FootTest extends JPanel
{
  // Fields
  private Image shoe;
  Foot eyes;
  Foot mouth;
  Foot square;
  Foot foot;
  int x = 0;
  int y = 0; 
  int stepLength;

  // Constructor
  public FootTest()
  {
    shoe = (new ImageIcon("leftshoe.gif")).getImage();

    x = 120;
    y = 100;
    eyes = new Foot(x, y, shoe);
    eyes.turn(-90);
    
    x = 55;
    y = 240;
    mouth = new Foot(x, y, shoe);
    mouth.turn(30);
    
    x = 300;
    y = 250;

    square = new Foot(x, y, shoe);
    
    x = 150;
    y = 250;
    
    foot = new Foot(x, y, shoe);
    foot.turn(-90);
    // Instantiates the objects I will be using throughout the program
  }

  // Called automatically when the panel needs repainting
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    stepLength = 250;
    for (int count = 0; count < 2; count++)
    {
      eyes.draw(g);
      eyes.moveSideways(stepLength);
      eyes.draw(g);
   } //Draws eyes

    stepLength = 25;
    for (int i = 0; i < 17; i++) {
    	mouth.draw(g);
    	mouth.moveForward(stepLength);
    	mouth.moveSideways(stepLength);
    	mouth.turn(-10);
    }// Draws mouth
    g.drawLine(15, 240, 105, 240);
    g.drawLine(55, 190, 55, 290);// Draws a cross where the first foot was drawn
    stepLength = 61;
    for (int count = 1; count <= 4; count++)
    {
      square.draw(g);
      square.moveSideways(-40);
      square.turn(90);
      square.moveSideways(stepLength);
    } //Draws a square

    // Draw a cursor at the expected center of the first "shoe":
    
    
    
    stepLength = 70;
    for (int count = 1; count <= 4; count++)
    {
      foot.draw(g);
      foot.moveSideways(stepLength);
    } //Draws 4 north facing feet
     
    
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Feet");
    window.setBounds(100, 100, 500, 480);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    FootTest panel = new FootTest();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
  }
}
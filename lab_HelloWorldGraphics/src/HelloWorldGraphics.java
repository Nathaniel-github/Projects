/*
 * Author: Nathaniel Thomas
 * Date: 9/26/19
 * Rev: 01
 */

//  This program shows simple graphics in a window.

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class HelloWorldGraphics extends JPanel
{
	static int xcord;
	static int ycord;
public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //  to paint the background
    g.setColor(Color.RED);

    // Draw a 150 by 45 rectangle with the upper-left
    // corner at x = 20, y = 40:
    int textsize;
    textsize = 11;
    if ((xcord + ycord) / 18 < xcord / 13) { //Calculates the text size based on how big the screen is so that the text is always on the screen
    textsize = (xcord + ycord) / 18;
    }
    if (xcord / 13 < (xcord + ycord) / 18) { //Same as above
    	textsize = xcord / 13;
    }
    g.drawRect(getWidth()/2 - (xcord/2), getHeight()/2 - (ycord/2), xcord, ycord); //Draws a rectangle based on the given input of width and height
    
    g.setFont(new Font("Tahona", Font.PLAIN, textsize)); //Sets the text size to the variable calculated above
    g.setColor(Color.WHITE);

    // Draw a string of text starting at x = 55, y = 65:
    g.drawString("GRAPHICS IN JAVA", getWidth()/2 - (textsize * 5), getHeight()/2 + (textsize/3)); //Draws the string based on where the center of the rectangle is and how large the string is
  }

  public static void main(String[] args)
  {
	  Scanner myobj = new Scanner(System.in);
	  System.out.println("Enter the width of your rectangle"); //Gets user input for the width of the rectangle
	    xcord = myobj.nextInt();
	  System.out.println("Enter the height of your rectangle"); //Gets user input for the height of the rectangle
	    ycord = myobj.nextInt();
	    myobj.close();
    JFrame window = new JFrame("Graphics Made By Me"); //Sets the name of the new window
    // Set this window's location and size:
    // upper-left corner at 300, 300; width 200, height 150
    window.setBounds(300, 300, 400, 300);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    HelloWorldGraphics panel = new HelloWorldGraphics();
    panel.setBackground(Color.BLUE);  // the default color is light gray
    Container c = window.getContentPane();
    c.add(panel);
    
    window.setLocationRelativeTo(null);//Center the window in the middle of the screen
    window.setVisible(true);
  }
}


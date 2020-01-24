/**
 *  Author:  Nathaniel Thomas
 *  Date:    9/27/2019
 *  Rev:     03
 *  Notes:   Based on Skylit Question 2.13.a
 *           The BullsEye class draws a Bulls Eye centered between (0, 0) and (xWidth, xHeight)
 *           
 *           Mods:
 *           This program has been modified from the original to do a wider variety of things.
 *           It no longer just draws a bulls eye centered but it draws a customizable bulls eye
 *           in the middle of your monitor that can be customized to do things such as change color
 *           make more rings in the bulls eye and grow and shrink the bulls eye.;
 *           
 */
import java.awt.*;
import javax.swing.*;

public class BullsEye extends JPanel
{

	// Fields
	int radius;
	
	// Constructors
	public BullsEye() {
		
	}

	// Methods
	
	// Draws a bulls eye centered in the middle of the screen that will enlarge and shrink as well as change colors
	public void draw (Graphics g, int xWidth, int yHeight, int Rings, Color RANDCOLOR1, Color RANDCOLOR2, int addRings)
	{
		int xCenter = xWidth / 2;
	    int yCenter = yHeight / 2;//Finds the middle of the screen and stores it in coordinates
	    Rings += addRings;//Sets the value of the number of rings to include those added
		for (int i = 0; i < Rings; i++) {
		    radius = ((xWidth/5) * (Rings - i)) / (Rings - addRings); //Takes the proportion of the original ring and makes the next ring a smaller proportion of it and continues this for the number of rings specified
		    if (i % 2 == 1) { //Checks if i is odd
				g.setColor(RANDCOLOR1);//Every other ring will be this color
			}  
			if (i % 2 == 0) { //Checks if i is even
				g.setColor(RANDCOLOR2);//Every other ring will be this color
			}
		    g.fillOval(xCenter - radius, yCenter - radius, radius * 2, radius * 2);//Draws the ring of the bulls eye given the specifications
		}
	}
	public int getRadius() { //Method that will allow other classes to access the radius variable
		return radius; //Returns the radius to the method
	}
	
}


/**
 *  Author:  Nathaniel Thomas
 *  Date:    9/27/2019
 *  Rev:     01
 *  Notes:   Based on Skylit Question 2.13.a
 *           The BullsEye class draws bulls eye centered between (0, 0) and (xWidth, xHeight)
 *           
 */
import java.awt.*;
import javax.swing.*;

public class BullsEye extends JPanel
{

	// Fields
	
	// Constructors
	public BullsEye() {
		
	}

	// Methods
	
	// Draws a bulls eye centered between (0, 0) and (xWidth, xHeight)
	public void draw (Graphics g, int xWidth, int yHeight)
	{
		int xCenter = xWidth / 2;
	    int yCenter = yHeight / 2;
	    int malnum;
	    malnum = xWidth / 3 * 2; // malnum is a number that I can change into anything I want so that I can use it in the draw method. It also makes the code a lot clearer
	    
	    g.setColor(Color.RED);
	    g.fillOval(xCenter - xWidth/3, yCenter - xWidth/3, malnum, malnum); //This is code that will scale the circle at the center of the screen and in proportion with the screen at all times
	   // g.fillOval(xCenter - 90, yCenter - 90, 180, 180);
	    
	    malnum = (xWidth * 4)/9;
	    g.setColor(Color.WHITE);
	    g.fillOval(xCenter - malnum/2, yCenter - malnum/2, malnum, malnum); //This is code that will scale the circle at the center of the screen and in proportion with the screen at all times
	   // g.fillOval(xCenter - 60, yCenter - 60, 120, 120);
	    
	    
	    g.setColor(Color.RED);
	    g.fillOval(xCenter - xWidth/9, yCenter - xWidth/9, malnum/2, malnum/2); //This is code that will scale the circle at the center of the screen and in proportion with the screen at all times
	    //g.fillOval(xCenter - 30, yCenter - 30, 60, 60);
	}
	
}


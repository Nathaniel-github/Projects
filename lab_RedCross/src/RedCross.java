/**
 *  Author:  Nathaniel Thomas
 *  Date:    9/27/2019
 *  Rev:     01
 *  Notes:   Based on Skylit Question 2.13.a
 *           The RedCross class draws a red cross centered between (0, 0) and (xWidth, xHeight)
 *           
 *           There are bugs for you to fix!
 */
import java.awt.*;
import javax.swing.*;

public class RedCross extends JPanel
{

	// Fields
	
	// Constructors
	public RedCross() {
		
	}

	// Methods
	
	// Draws a red cross centered between (0, 0) and (xWidth, xHeight)
	public void draw (Graphics g, int xWidth, int yHeight)
	{
		int xCenter = xWidth / 2;
	    int yCenter = yHeight / 2;
		
	    g.setColor(Color.RED);
	    g.fillRect(xCenter - xWidth / 36, yCenter - yHeight / 4, xWidth / 18, yHeight / 2);
	    g.fillRect(xCenter - xWidth / 6, yCenter - yHeight / 30, xWidth / 3, yHeight / 15);
	    //g.fillRect(xCenter, yCenter, 10, 50); used to be the code which is not right because it prints the rectangle starting at the center when we actually want it to be in the center. This is fixed by subrtracting half of the rectangles length and width from the printing point.
	    //g.fillRect(xCenter, yCenter, 50, 10); used to be the code which is not right because it prints the rectangle starting at the center when we actually want it to be in the center. This is fixed by subrtracting half of the rectangles length and width from the printing point.
		    
	}
	
}


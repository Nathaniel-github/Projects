import java.awt.*;

import javax.swing.*; // javax.swing was imported so that we could use the methods getWidth and getHeight

/**
 * 
 * Author:  Nathaniel Thomas
 * Date:    9/27/2019
 * Rev:     01
 * Notes:   Based on Skylit Question 2.13.a
 *          Makes a "DrawingPanel" - JFrame containing a JPanel
 *          Has a BullsEye object
 *          Calls the BullsEye' draw() method to draw a Bulls Eye centered in the JPanel whenever the window is resized 
 */
//This program is supposed to draw a bulls eye in the middle of the screen
//public class SimpleWindow extends JPanel implements KeyListener
public class DrawingPanel extends JPanel {
	

	//Fields
	private BullsEye bullsEye; //The BullsEye object is declared here

	// Constructors
	
	// No args constructor
	// calls JPanel constructor
	// instantiates a BullsEye object
	// sets the background color to WHITE
	public DrawingPanel() {
		super();
		bullsEye = new BullsEye(); //The BullsEye object is instantiated here. There is only one BullsEye object
		setBackground(Color.WHITE);
	}

	// Methods
	
	// Paint Component is called when the window is drawn initially and whenever the window is resized
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint the background

		int width = getWidth(); // getWidth is called here (Line 42)
		int height = getHeight(); //getHeight is called here (Line 43)

		// The getWidth and getHeight methods get the width and the height of the screen constantly
		//  defer drawing the red cross to a BullsEye object
		bullsEye.draw(g,width, height); //The draw method from the BullsEye object is called here
	}
	
	//
	// Instantiate the JFrame and set a few properties
	// Instantiate a DrawingPanel, set a few properties, and add it to the JFrame
	//
	public static void main(String[] args) {
		JFrame window = new JFrame("Bulls Eye");
		window.setBounds(300, 300, 200, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawingPanel panel = new DrawingPanel();
		//panel.setBackground(Color.WHITE);
		Container c = window.getContentPane();
		c.add(panel);
		window.setVisible(true);
	}

}
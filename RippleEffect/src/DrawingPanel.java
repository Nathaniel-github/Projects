import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*; // javax.swing was imported so that we could use the methods getWidth and getHeight

/**
 * 
 * Author:  Nathaniel Thomas
 * Date:    9/27/2019
 * Rev:     01
 */
//This program is supposed to draw a cross in the middle of the screen
//public class SimpleWindow extends JPanel implements KeyListener
public class DrawingPanel extends JPanel {
	
	private static int rings = 2;
	static Color randomColor1 = Color.WHITE;
	static Color randomColor2 = Color.RED;
	static int addRings = 0;
	static boolean reset = false;
	//Fields
	private RippleEffect rippleEffect; //The rippleEffect object is declared here
	// Constructors
	
	// No args constructor
	// calls JPanel constructor
	// instantiates a RippleEffect object
	// sets the background color to WHITE
	public DrawingPanel() {
		super();
		rippleEffect = new RippleEffect(); //The RippleEffect object is instantiated here. There is only one redCross object
		setBackground(Color.WHITE);//Sets the background color to white
	}

	// Methods
	
	// Paint Component is called when the window is drawn initially and whenever the window is resized
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint the background
		int width = getWidth(); // getWidth is called here (Line 42)
		int height = getHeight(); //getHeight is called here (Line 43)
		// The getWidth and getHeight methods get the width and the height of the screen constantly
		//  defer drawing the red cross to a RippleEffect object
		rippleEffect.draw(g,width, height, rings, randomColor1, randomColor2, addRings, reset); //The draw method from the redCross object is called here and takes in the parameters needed
	}
	//
	// Instantiate the JFrame and set a few properties
	// Instantiate a DrawingPanel, set a few properties, and add it to the JFrame
	//
	public static void main(String[] args) {
		boolean colors = true;
		int delay = 75;
		boolean Yes = true;//Sets the default value of wether the user wants epansion or not to no so that if the user types yes only then the variable needs to be changed
		JFrame window = new JFrame("Ripple Effect");//Titles the new window Bulls Eye
		window.setBounds(300, 300, 200, 200);//Sets the size of the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawingPanel panel = new DrawingPanel();//Declares and instantiates a DrawingPanel object called panel
		Container c = window.getContentPane();
		c.add(panel);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		while (true) { //Infinite loop
			try { //The java interpreter attempts the code inside the try statement
				TimeUnit.MILLISECONDS.sleep(delay);//Delays the code for however many Milliseconds the user wanted
			} 
			catch (InterruptedException ie) { //catches the throw from the previous method call
				Thread.currentThread().interrupt();//Handles the throw with the following code
			}
			reset = false;
			Random rand = new Random();//Declares and instantiates a Random object (A random number generator is made)
			if (colors) { //If user wanted the color of the rings to change then this code will run
				float Red = rand.nextFloat();
				float Green = rand.nextFloat();
				float Blue = rand.nextFloat();//Sets the variables to random numbers between 0 and 1
				randomColor2 = new Color(Red, Green, Blue);//Creates a new color based on the numbers generated
			}
			if (Yes) { //If the user wanted the bulls eye to expand and shrink then the expansion and shrinking will start
				if ((rings + 4) > addRings) { //Adds rings to the bulls eye and stops when the amount of rings added becomes satisfactory
					addRings++;
					if (rings == addRings) {
						reset = true;
					}
				}
				else {
					rings = 2;
					addRings = 0;
					reset = false;
				}
			}
			panel.repaint();//Repaints the screen with the new changes that were applied to the color, size, and number of the rings
			
		}
	}
}


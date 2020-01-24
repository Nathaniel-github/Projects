import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*; // javax.swing was imported so that we could use the methods getWidth and getHeight

/**
 * 
 * Author:  Nathaniel Thomas
 * Date:    10/29/2019
 * Rev:     6 (Halloween Edition)
 * Notes:   Based on Skylit Question 2.13.a
 *          Makes a "DrawingPanel" - JFrame containing a JPanel
 *          Has a BullsEye object
 *          Calls the BullsEye' draw() method to draw a Bulls Eye centered in the JPanel whenever the window is resized 
 */
//This program is supposed to draw a bulls eye in the middle of the screen
//public class SimpleWindow extends JPanel implements KeyListener
public class DrawingPanel extends JPanel {
	
	private static int rings = 3;
	static Color randomColor1 = Color.WHITE;
	static Color randomColor2 = Color.RED;
	static CheckInput myChecker = new CheckInput();
	static int addRings = 0; //The static fields make it so that the variables can be used throughout the program no matter where it is (the main method)
	static int delay = 75;
	//Fields
	private BullsEye bullsEye; //The bullsEye object is declared here
	// Constructors
	
	// No args constructor
	// calls JPanel constructor
	// instantiates a BullsEye object
	// sets the background color to WHITE
	public DrawingPanel() {
		super();
		bullsEye = new BullsEye(); //The BullsEye object is instantiated here. There is only one redCross object
		setBackground(Color.WHITE);//Sets the background color to white
	}

	// Methods
	
	// Paint Component is called when the window is drawn initially and whenever the window is resized
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Call JPanel's paintComponent method to paint the background
		int width = getWidth(); // getWidth is called here (Line 42)
		int height = getHeight(); //getHeight is called here (Line 43)
		// The getWidth and getHeight methods get the width and the height of the screen constantly
		//  defer drawing the red cross to a BullsEye object
		bullsEye.draw(g,width, height, rings, randomColor1, randomColor2, addRings); //The draw method from the redCross object is called here and takes in the parameters needed
	}
	//
	// Instantiate the JFrame and set a few properties
	// Instantiate a DrawingPanel, set a few properties, and add it to the JFrame
	//
	public static void main(String[] args) {
		String bothColors = "";
		Scanner myobj = new Scanner(System.in);
		boolean colors = false;
		boolean expansion = false;
		boolean shrink = false;
		boolean stop = false;
		boolean reset = true;
		boolean fullProgram = true;
		boolean bothColorsChange = false;//Sets default value of the variables being used
		/*
		 String og = myChecker.getYesNo("Would you like the original version of the code? (y/n)");//Gets either a yes or a no from the user and won't continue the code otherwise
		
		if (og.equals("y") || og.equals("yes") || og.equals("Yes")) { //If the original version is wanted of the program it will set the variable to false so the full code won't run
			fullProgram = false;
		}
		*/
		if (fullProgram) { //If the person wants the extended version of the original program this will run
			rings = myChecker.getInt("Enter the number of rings you want"); //Gets an integer from the user and will not continue otherwise
			String colorChange = myChecker.getMessage("Do you want the color of the ring to change? (y/n)", "Yes yes y No no n SPOOK Spook spook"); //Checks to see if the user input is one of parameters given
			if (colorChange.equals("y") || colorChange.equals("yes") || colorChange.equals("Yes")) { //Depending on if the user wishes to have the color change this code will run
				colors = true;
				bothColors = myChecker.getYesNo("Would you like all the rings to change colors? (If not then only one set will change colors) (y/n)");
			}
			else if (colorChange.equals("SPOOK") || colorChange.equals("Spook") || colorChange.equals("spook")) { //If the phrase is typed in then the colors of the rings will be orange and black
				randomColor1 = Color.ORANGE;
				randomColor2 = Color.BLACK;
			}
			delay = myChecker.getInt("Enter how fast you want the change in milliseconds");
			if (bothColors.equals("y") || bothColors.equals("yes") || bothColors.equals("Yes")) { //Depending on if the user wanted both colors of the bulls eye to change this code will run
				bothColorsChange = true;//Sets value to variable
			}
			String answer = "";
			answer = myChecker.getYesNo("Would you like the bulls eye to grow and shrink? (y/n)");
			if (answer.equals("y") || answer.equals("yes") || answer.equals("Yes")) { //Sets boolean to true based on if the user input matched a yes or something else
				expansion = true;
			}
			JFrame window = new JFrame("Bulls Eye");//Titles the new window Bulls Eye
			window.setBounds(300, 300, 200, 200);//Sets the size of the window
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			DrawingPanel panel = new DrawingPanel();//Declares and instantiates a DrawingPanel object called panel
			Container c = window.getContentPane();
			c.add(panel);
			window.setLocationRelativeTo(null); //Places window in the middle of the screen
			window.setVisible(true);
			myobj.close();
			BullsEye getNum = new BullsEye();//Declares and instantiates a BullsEye object called getNum
			while (true) { //Infinite loop
				try { //The java interpreter attempts the code inside the try statement
					TimeUnit.MILLISECONDS.sleep(delay);//Delays the code for however many Milliseconds the user wanted
				} 
				catch (InterruptedException ie) { //catches the throw from the previous method call
					Thread.currentThread().interrupt();//Handles the throw with the following code
				}
				Random rand = new Random();//Declares and instantiates a Random object (A random number generator is made)
				if (colors) { //If user wanted the color of the rings to change then this code will run
					if (bothColorsChange) { //If user wanted both colors to change both of the rings colors' then this code will run
						float r = rand.nextFloat();
						float G = rand.nextFloat();
						float b = rand.nextFloat();//Sets the variables to random numbers between 0 and 1
						randomColor1 = new Color(r, G, b);//Creates a new color based on the numbers generated
					}
					float Red = rand.nextFloat();
					float Green = rand.nextFloat();
					float Blue = rand.nextFloat();//Sets the variables to random numbers between 0 and 1
					randomColor2 = new Color(Red, Green, Blue);//Creates a new color based on the numbers generated
				}
				int radius = getNum.getRadius();//Gets the radius from the BullsEye class so it can be used in the Drawing Panel
				if (expansion) { //If the user wanted the bulls eye to expand and shrink then the expansion and shrinking will start
					if (reset) { //If the reset variable is true then the code will be executed
						shrink = false;
						stop = false;
						reset = false;//Sets the values for the variables every time the bulls eye expands and shrinks
					}
					if ((radius * 2) < 180 && rings > addRings && !shrink) { //Adds rings to the bulls eye and stops when the amount of rings added becomes satisfactory
							addRings++;
					}
					else { //Once the size of the bulls eye is satisfactory then the shrinking process is started
						shrink = true;
					}
					if (shrink && !stop) { //Checks if shrinking process needs to start and if so then starts to shrink the bulls eye 
						addRings -= 1;
					}
					if (addRings <= 0) { //Checks if the amount of rings the bulls eye has isn't more than it started at
						stop = true;
					}
					if (stop) { //If the size of the bulls eye is as small as it started then it starts the process of adding and subtracting rings again
						reset = true;
					}
				}
				panel.repaint();//Repaints the screen with the new changes that were applied to the color, size, and number of the rings
			}
		}
		else { //If the person wants the original version of the code this will run
			JFrame window = new JFrame("Bulls Eye");//Titles the new window Bulls Eye
			window.setBounds(300, 300, 200, 200);//Sets the size of the window
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//panel.setBackground(Color.WHITE);
			window.setLocationRelativeTo(null);
			DrawingPanel panel = new DrawingPanel();//Declares and instantiates a DrawingPanel object called panel
			Container c = window.getContentPane();
			c.add(panel);
			window.setVisible(true);
		}
		myobj.close();
	}
}

